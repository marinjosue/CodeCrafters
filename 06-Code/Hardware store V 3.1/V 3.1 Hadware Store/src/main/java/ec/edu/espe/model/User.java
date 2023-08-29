package ec.edu.espe.model;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class User {

    private String names;
    private String lastnames;
    private String address;
    private String CI;
    private String email;

    public User(String nombres, String apellidos, String direccion, String CI, String email) {
        this.names = nombres;
        this.lastnames = apellidos;
        this.address = direccion;
        this.CI = CI;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getCI() {
        return CI;
    }

    public String getNames() {
        return names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public String getAddress() {
        return address;
    }
}
