
package ec.edu.espe.model;

import com.mongodb.client.MongoCollection;
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
    

    public newUser(String nombre, String apellido, String ci, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.direccion = direccion;
        this.email = email;
        
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

   


    public static boolean validar(newUser user, MongoCollection<Document> collection) {
        if (user.nombre.isEmpty() || user.apellido.isEmpty() || user.ci.isEmpty() || user.direccion.isEmpty() || user.email.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos requeridos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (user.nombre.matches(".*\\d.*") || user.apellido.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre y apellido válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (user.ci.length() != 10 || !user.ci.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Ingrese una cédula válida de 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {

            Document existingUser = collection.find(new Document("ci", user.ci)).first();
            if (existingUser != null) {
                JOptionPane.showMessageDialog(null, "Usuario ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                String[] nombres = user.nombre.split(" ");
                String[] apellidos = user.apellido.split(" ");

                if (nombres.length != 2 || apellidos.length < 2 || apellidos.length > 3) {
                    JOptionPane.showMessageDialog(null, "Ingrese dos nombres y de dos a tres apellidos", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    public static void registrar(newUser user, MongoCollection<Document> collection) {
        StringBuilder nombresTexto = new StringBuilder();
        for (String nombre : user.nombre.split(" ")) {
            nombresTexto.append(nombre).append(" ");
        }

        StringBuilder apellidosTexto = new StringBuilder();
        for (String apellido : user.apellido.split(" ")) {
            apellidosTexto.append(apellido).append(" ");
        }

        Document document = new Document();
        document.append("nombres", nombresTexto.toString().trim());
        document.append("apellidos", apellidosTexto.toString().trim());
        document.append("ci", user.ci);
        document.append("direccion", user.direccion);
        document.append("email", user.email);
        

        collection.insertOne(document);

        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
    }
}

