
package ec.edu.espe.model;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda CodeCrafters: DCCO-ESPE
 */
import java.util.ArrayList;
import java.util.List;

public class HardwareStore {
    private int id;
    private String name;
    private int batch;
    private int amount;
    private List<Product> productList;
    private String email;
    private Cart cart;

    public HardwareStore() {
        productList = new ArrayList<>();
        cart = new Cart();
    }

    public HardwareStore(int id, String name, int batch, int amount1, List<Product> productList, String email) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.amount = amount;
        this.productList = productList;
        this.email = email;
    }

    @Override
    public String toString() {
        return "HardwareStore{" + "id=" + id + ", name=" + name + ", batch=" + batch + ", amount=" + amount + ", productList=" + productList + ", email=" + email + '}';
    }

    public void checkIn() {

    }

    public List<Product> consult(List<Product> productList) {

        return null;
    }

    public void add(List<Product> productList) {

    }

    public void remove(List<Product> productList) {

    }

    public void modify(Product product) {

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the batch
     */
    public int getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(int batch) {
        this.batch = batch;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

  public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public Object getProducts() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}