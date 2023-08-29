package ec.edu.espe.controller;

import com.mongodb.client.MongoCollection;

import org.bson.Document;

import javax.swing.*;

public class DiscountManager {

    private DatabaseConnection dbConnection;
    private final JTextField txtDisscount;

    public DiscountManager(DatabaseConnection dbConnection, javax.swing.JTextField txtDisscount) {
        this.dbConnection = dbConnection;
        this.txtDisscount = txtDisscount;
    }

    public DiscountManager(JTextField txtPrice) {
        this.txtDisscount = txtPrice;
    }

    public void applyDiscount(String discountText, String productIdText) {
        try {
            int discount = Integer.parseInt(discountText);
            int productId = Integer.parseInt(productIdText);
            MongoCollection<Document> collection = dbConnection.getCollection();

            Document query = new Document("id", productId);
            Document document = collection.find(query).first();
            if (document != null) {
                double price = document.getDouble("price");
                if (discount >= 0 && discount <= 100) {
                    double discountedPrice = price * (1 - (discount / 100.0));
                    document.put("price", discountedPrice);
                    document.put("discountPercentage", discount);

                    collection.replaceOne(query, document);

                    int id = document.getInteger("id");
                    String name = document.getString("name");

                    StringBuilder confirmationMessage = new StringBuilder();
                    confirmationMessage.append("Discount applied to product:").append("\n\n");
                    confirmationMessage.append("ID: ").append(id).append("\n");
                    confirmationMessage.append("Name: ").append(name).append("\n");
                    confirmationMessage.append("Discounted Price: ").append(discountedPrice).append("\n");
                    confirmationMessage.append("Discounted Applied: ").append(discount).append("\n");
                    JOptionPane.showMessageDialog(null, confirmationMessage.toString(), "Discount Applied", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Discount percentage must be between 0 and 100", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No product found with the entered ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter only integers", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
