package ec.edu.espe.controller;

import ec.edu.espe.model.UserData;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.view.MenuOwner;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class UserAuthentication {

    public static void authenticateUser(String username, String password) {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection("owner");
            MongoCollection<Document> collection = dbConnection.getCollection();
            Document query = new Document("user", username);
            Document existingUser = collection.find(query).first();

            if (existingUser != null) {
                String stored = existingUser.getString("password");

                AESCipher aesCipher = new AESCipher();
                String storedDecrypted = aesCipher.decrypt(stored);

                if (storedDecrypted.equals(password)) {
                    UserData.userCi = username;
                    MenuOwner owner = new MenuOwner();
                    owner.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al procesar la solicitud", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
