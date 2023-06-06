
package ec.edu.espe.model;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda CodeCrafters: DCCO-ESPE
 */

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    
       public Cart() {
        products = new ArrayList<>();
    }

    public void setCart(List<Product> products) {
        this.products = products;
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public float getTotal() {
        float total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
    
    public List<Product> getProducts() {
        return products;
    }
}
