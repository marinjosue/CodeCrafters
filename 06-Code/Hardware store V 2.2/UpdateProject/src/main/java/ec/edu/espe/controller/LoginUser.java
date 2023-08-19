package ec.edu.espe.controller;


import org.bson.Document;
import com.mongodb.client.MongoCollection;

public class LoginUser {

    private DatabaseConnection dbConnection;

    public LoginUser(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public boolean loginUser(String userCi) {
        MongoCollection<Document> collection = dbConnection.getCollection();
        
        Document query = new Document("ci", userCi);
        Document existingUser = collection.find(query).first();

        if (existingUser != null) {
            String storedCi = existingUser.getString("ci");
            if (storedCi.equals(userCi)) {
                UserData.userCi = userCi; 
                return true;
            }
        }
        return false;
    }
}