package ec.edu.espe.controller;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.model.Comment;
import org.bson.Document;

/**
 *
 * @author Josue Marin, CodeCrafters: DCCO-ESPE
 */
public class CommentManager {

    private DatabaseConnection dbConnection;

    public CommentManager(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addComment(String name, String comment) {
        MongoCollection<Document> collection = dbConnection.getCollection();

        Comment commentData = new Comment(name, comment);
        Gson gson = new Gson();
        String json = gson.toJson(commentData);
        Document document = Document.parse(json);
        collection.insertOne(document);

        System.out.println("Comentario guardado correctamente");
    }
}
