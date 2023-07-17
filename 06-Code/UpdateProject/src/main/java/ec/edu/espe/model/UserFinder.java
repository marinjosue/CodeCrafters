
package ec.edu.espe.model;

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
        // Establecer la conexión con la base de datos MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb+srv://josuemarin:josuemarin@cluster0.lntjz9j.mongodb.net/");

        // Seleccionar la base de datos
        MongoDatabase database = mongoClient.getDatabase("Project");

        // Obtener una referencia a la colección deseada
        MongoCollection<Document> collection = database.getCollection("User");

        // Realizar la búsqueda en la colección
        Document query = new Document("ci", ci);
        Document existingUser = collection.find(query).first();

        mongoClient.close();

        if (existingUser != null) {
            String nombres = existingUser.getString("nombres");
            String apellidos = existingUser.getString("apellidos");
            String direccion = existingUser.getString("direccion");
            String CI = existingUser.getString("ci");
            String email = existingUser.getString("email");


            // Devolver un objeto User con los datos obtenidos
            return new User(nombres, apellidos, direccion, CI, email);
        } else {
            // Usuario no encontrado
            return null;
        }
    }
}




