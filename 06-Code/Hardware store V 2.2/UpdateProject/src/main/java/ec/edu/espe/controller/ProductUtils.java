
package ec.edu.espe.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javax.swing.JTextArea;
import org.bson.Document;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class ProductUtils {
    
    private DatabaseConnection dbConnection;

    public ProductUtils() {
        this.dbConnection = new DatabaseConnection("products"); 
    }

    public void displayStockZeroProducts(JTextArea txtAStock) {
        MongoCollection<Document> collection = dbConnection.getCollection();
        MongoCursor<Document> cursor = collection.find().iterator();
        StringBuilder stockZeroData = new StringBuilder();
        boolean hasStockZero = false;

        while (cursor.hasNext()) {
            Document document = cursor.next();
            int stock = document.getInteger("stock");

            if (stock == 0) {
                int id = document.getInteger("id");
                String name = document.getString("name");
                double price = document.getDouble("price");
                String description = document.getString("description");
                stockZeroData.append("ID: ").append(id).append("\n");
                stockZeroData.append("Name: ").append(name).append("\n");
                stockZeroData.append("Price: ").append(price).append("\n");
                stockZeroData.append("Description: ").append(description).append("\n\n");
                hasStockZero = true;
            }
        }

        if (hasStockZero) {
            txtAStock.setText(stockZeroData.toString());
        } else {
            txtAStock.setText("Todos los artículos tienen stock.");
        }
    }
}
