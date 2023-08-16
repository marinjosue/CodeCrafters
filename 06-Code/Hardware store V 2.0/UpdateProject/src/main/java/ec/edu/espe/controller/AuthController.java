
package ec.edu.espe.controller;

import javax.swing.JOptionPane;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.view.Cart;

/**
 *
 * @author Josue Marin, CodeCrafters: DCCO-ESPE
 */
public class AuthController {
    private MongoCollection<Document> collection;  

    public AuthController(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public void authenticateUser(String userCi) {
        Document query = new Document("ci", userCi);
        Document existingUser = collection.find(query).first();

        if (existingUser != null) {
            String storedCi = existingUser.getString("ci");
            if (storedCi.equals(userCi)) {
                UserData.userCi = userCi; 

                Cart cart = new Cart();
                cart.setVisible(true);           
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
}
