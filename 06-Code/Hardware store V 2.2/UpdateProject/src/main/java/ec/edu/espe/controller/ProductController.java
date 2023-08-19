/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.model.Product;
import java.util.List;
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


 
    
    public ProductController(MongoCollection<Document> collection, List<Product> cartProducts, JTable cartTable) {
        this.collection = collection;
        this.cartProducts = cartProducts;
        this.cartTable = cartTable;
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
                    if (quantity <= stock) {
                        int updatedStock = stock - quantity;
                        document.put("stock", updatedStock);
                        collection.replaceOne(new Document("id", id), document);

                        Product product = new Product(id, name, price, quantity);
                        cartProducts.add(product);
                        updateCartTable(); 
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad ingresada excede el stock disponible", "Error", JOptionPane.ERROR_MESSAGE);
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
        double totalPriceWithVAT = calculateTotalPrice(product.getPrice(), 12.0); // Cambia el 12.0 al valor adecuado del IVA
        double totalPrice = totalPriceWithVAT * quantity;
        product.setTotalPrice((float) totalPrice);
        totalValue += totalPrice;
        Object[] row = { product.getId(), product.getName(), product.getPrice(), quantity, totalPrice };
        cartTableModel.addRow(row);
    }
    cartTable.setModel(cartTableModel);
}

    public double calculateTotalPriceWithVAT() {
        double totalValue = 0.0;
        for (Product product : cartProducts) {
            double quantity = product.getQuantity();
            totalValue += calculateTotalPrice(product.getPrice(), 12.0) * quantity;
            String formattedPrice = String.format("%.2f", totalValue);
        
        }
        return totalValue;
    }

    public double calculateTotalPrice(double price, double iva) {
        double ivat = price * (iva / 100);
        double TotalPrice = price + ivat;
        String formattedTotalPrice = String.format("%.2f", TotalPrice);
        return TotalPrice;
    }

}