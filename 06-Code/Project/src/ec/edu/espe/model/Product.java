
package ec.edu.espe.model;

/**
 *
 * @author USER
 */
import java.util.List;
import java.util.Locale.Category;

public class Product {
    private int id;
    private String name;
    private int stock;
    private float price;
    private String description;
    private List<Category> categoryList;

    public Product(int id, String name, int stock, float price, String description, List<Category> categoryList) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.categoryList = categoryList;
    }

    public void checkIn() {
       
    }

    public void modifyProduct() {

    }

    public Product consult() {

        return null;
    }

    public void lowAmount() {

    }

    public void highAmount() {

    }
}
