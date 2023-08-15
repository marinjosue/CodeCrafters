
package ec.edu.espe.model;

import ec.edu.espe.controller.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class UserFinder {
    public static User findUser(String ci) {
       
        MongoClient mongoClient = MongoClients.create("mongodb+srv://josuemarin:josuemarin@cluster0.lntjz9j.mongodb.net/");

        MongoDatabase database = mongoClient.getDatabase("Project");

        MongoCollection<Document> collection = database.getCollection("User");

        Document query = new Document("ci", ci);
        Document existingUser = collection.find(query).first();

        mongoClient.close();

        if (existingUser != null) {
            String nombres = existingUser.getString("nombres");
            String apellidos = existingUser.getString("apellidos");
            String direccion = existingUser.getString("direccion");
            String CI = existingUser.getString("ci");
            String email = existingUser.getString("email");


            return new User(nombres, apellidos, direccion, CI, email);
        } else {
           
            return null;
        }
    }
}




