
package ec.edu.espe.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;



/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class DatabaseConnection {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public DatabaseConnection(String collectionName) {
        mongoClient = MongoClients.create("mongodb+srv://josuemarin:josuemarin@cluster0.lntjz9j.mongodb.net/");
        database = mongoClient.getDatabase("Project");
        collection = database.getCollection(collectionName);
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }
 }

