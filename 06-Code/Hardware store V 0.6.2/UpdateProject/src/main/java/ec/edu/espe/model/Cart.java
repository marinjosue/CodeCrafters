
package ec.edu.espe.model;

/**
 *
 * @author Josue Marin, Jhordy Marcillo, Jeffrey Manobanda, Mesias Mariscal CodeCrafters: DCCO-ESPE
 * 
 */

import ec.edu.espe.model.Product;
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

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
