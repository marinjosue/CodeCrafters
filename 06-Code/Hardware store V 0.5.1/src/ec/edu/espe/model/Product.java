
package ec.edu.espe.model;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda, Mesias Mariscal CodeCrafters: DCCO-ESPE
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
    private float regularPrice;
    private float discount;
    private float discountPercentage;

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Product(int id, String name, int stock, float price, String description, List<Category> categoryList) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.categoryList = categoryList;
        this.regularPrice = regularPrice;
    }
     public float getRegularPrice() {
        return regularPrice;
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
