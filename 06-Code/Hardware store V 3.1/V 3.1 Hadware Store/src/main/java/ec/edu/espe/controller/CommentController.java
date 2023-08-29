package ec.edu.espe.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author USER
 */
public class CommentController {

    public CommentController(DatabaseConnection dbConnection1) {
        this.dbConnection = dbConnection1;
    }
    private DatabaseConnection dbConnection;

    public DatabaseConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void loadProductsFromDatabase(DefaultTableModel tableModel) {
        MongoCollection<Document> collection = dbConnection.getCollection();
        MongoCursor<Document> cursor = collection.find().iterator();
        tableModel.setRowCount(0);

        while (cursor.hasNext()) {
            Document document = cursor.next();
            String name = document.getString("name");
            String comment = document.getString("content");
            Object[] row = {name, comment};
            tableModel.addRow(row);
        }
    }
}
