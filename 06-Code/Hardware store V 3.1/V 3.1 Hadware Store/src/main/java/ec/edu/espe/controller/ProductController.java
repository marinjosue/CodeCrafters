package ec.edu.espe.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.model.Product;
import java.text.NumberFormat;

import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

public class ProductController {

    private final MongoCollection<Document> collection;
    private final List<Product> cartProducts;
    private final JTable cartTable;
    private final JTextField txtPrice;

    public ProductController(MongoCollection<Document> collection, List<Product> cartProducts, JTable cartTable, JTextField txtPrice) {
        this.collection = collection;
        this.cartProducts = cartProducts;
        this.cartTable = cartTable;
        this.txtPrice = txtPrice;
    }

    public void btnAddActionPerformed(java.awt.event.ActionEvent evt, JTextField txtIdCart, JSpinner spnQuantity) {
        try {
            int id = Integer.parseInt(txtIdCart.getText());
            Document document = collection.find(new Document("id", id)).first();
            if (document != null) {
                String name = document.getString("name");
                Double price = document.getDouble("price");
                int stock = document.getInteger("stock");

                if (stock > 0) {
                    int quantity = (int) spnQuantity.getValue();
                    if (quantity > 0 && quantity <= stock) {
                        int updatedStock = stock - quantity;
                        document.put("stock", updatedStock);
                        collection.replaceOne(new Document("id", id), document);

                        boolean found = false;
                        for (Product product : cartProducts) {
                            if (product.getId() == id) {
                                product.setQuantity(product.getQuantity() + quantity);
                                product.setTotalPrice((float) (product.getTotalPrice() + (price * quantity)));
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            Product product = new Product(id, name, price, quantity);
                            cartProducts.add(product);
                        }

                        updateCartTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad ingresada debe ser mayor que 0 y no exceder el stock disponible", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El producto seleccionado no se encuentra disponible", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese solo números en el campo ID", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void updateCartTable() {
        DefaultTableModel cartTableModel = (DefaultTableModel) cartTable.getModel();
        cartTableModel.setRowCount(0);

        double totalValue = 0.0;

        for (Product product : cartProducts) {
            double quantity = product.getQuantity();
            double totalPrice = product.getPrice() * quantity;
            totalValue += totalPrice;

            Locale locale = new Locale("en", "US");
            NumberFormat nf = NumberFormat.getNumberInstance(locale);
            nf.setMaximumFractionDigits(2);

            Object[] row = {
                product.getId(),
                product.getName(),
                product.getPrice(),
                quantity,
                nf.format(totalPrice)
            };
            cartTableModel.addRow(row);
        }

        cartTable.setModel(cartTableModel);

        NumberFormat totalValueFormat = NumberFormat.getNumberInstance(Locale.US);
        totalValueFormat.setMaximumFractionDigits(2);
        txtPrice.setText(totalValueFormat.format(totalValue));
    }

}
