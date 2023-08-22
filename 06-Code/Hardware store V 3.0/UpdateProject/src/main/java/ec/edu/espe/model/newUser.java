
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
    private String nombre;
    private String apellido;
    private String ci;
    private String direccion;
    private String email;
    private DatabaseConnection dbConnection;


    public newUser(String nombre, String apellido, String ci, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.direccion = direccion;
        this.email = email;
        this.dbConnection = new DatabaseConnection("User");
        
    }

    public DatabaseConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public boolean validar() {
        if (nombre.isEmpty() || apellido.isEmpty() || ci.isEmpty() || direccion.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (nombre.matches(".*\\d.*") || apellido.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre y apellido válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (ci.length() != 10 || !ci.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Ingrese una cédula válida de 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public void registrar() {
        if (validar()) {
            MongoCollection<Document> collection = dbConnection.getCollection();
            
            StringBuilder nombresTexto = new StringBuilder();
            for (String nombre : this.nombre.split(" ")) {
                nombresTexto.append(nombre).append(" ");
            }

            StringBuilder apellidosTexto = new StringBuilder();
            for (String apellido : this.apellido.split(" ")) {
                apellidosTexto.append(apellido).append(" ");
            }

            Document document = new Document();
            document.append("nombres", nombresTexto.toString().trim());
            document.append("apellidos", apellidosTexto.toString().trim());
            document.append("ci", this.ci);
            document.append("direccion", this.direccion);
            document.append("email", this.email);

            collection.insertOne(document);

            JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
        }
    }
}

