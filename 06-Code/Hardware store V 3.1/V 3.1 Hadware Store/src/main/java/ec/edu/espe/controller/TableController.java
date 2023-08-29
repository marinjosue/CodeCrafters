package ec.edu.espe.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author USER
 */
public class TableController {

    private DatabaseConnection dbConnection;
    private DatabaseConnection dbConnection2;

    public TableController(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public DefaultTableModel getTableModel() {
        MongoCollection<Document> collection = dbConnection.getCollection();
        MongoCursor<Document> cursor = collection.find().iterator();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Stock");
        tableModel.addColumn("Price");
        tableModel.addColumn("Description");

        while (cursor.hasNext()) {
            Document document = cursor.next();
            int id = document.getInteger("id");
            String name = document.getString("name");
            int stock = document.getInteger("stock");
            double price = document.getDouble("price");
            String description = document.getString("description");

            Object[] row = {id, name, stock, price, description};
            tableModel.addRow(row);
        }
        return tableModel;
    }

}
