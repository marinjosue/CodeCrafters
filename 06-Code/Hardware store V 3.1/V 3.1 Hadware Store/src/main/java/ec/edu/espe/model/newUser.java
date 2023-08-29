package ec.edu.espe.model;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.controller.DatabaseConnection;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class newUser {

    private String name;
    private String lastname;
    private String ci;
    private String address;
    private String email;
    private DatabaseConnection dbConnection;

    public newUser(String nombre, String apellido, String ci, String direccion, String email) {
        this.name = nombre;
        this.lastname = apellido;
        this.ci = ci;
        this.address = direccion;
        this.email = email;
        this.dbConnection = new DatabaseConnection("User");

    }

    public DatabaseConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String apellido) {
        this.lastname = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String direccion) {
        this.address = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validate() {
        if (name.isEmpty() || lastname.isEmpty() || ci.isEmpty() || address.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (name.matches(".*\\d.*") || lastname.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre y apellido válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (ci.length() != 10 || !ci.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Ingrese una cédula válida de 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public void toregister() {
        if (validate()) {
            MongoCollection<Document> collection = dbConnection.getCollection();

            StringBuilder nombresTexto = new StringBuilder();
            for (String nombre : this.name.split(" ")) {
                nombresTexto.append(nombre).append(" ");
            }

            StringBuilder apellidosTexto = new StringBuilder();
            for (String apellido : this.lastname.split(" ")) {
                apellidosTexto.append(apellido).append(" ");
            }

            Document document = new Document();
            document.append("nombres", nombresTexto.toString().trim());
            document.append("apellidos", apellidosTexto.toString().trim());
            document.append("ci", this.ci);
            document.append("direccion", this.address);
            document.append("email", this.email);

            collection.insertOne(document);

            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
        }
    }
}
