
package ec.edu.espe.view;

/**
 *
 * @author USER
 */
import ec.edu.espe.model.Product;

import java.util.List;

public class ProductMenu {
    public static void showProductList(List<Product> productList) {
        System.out.println("---------- Lista de Productos ----------");
        for (Product product : productList) {
            System.out.println("ID: " + product.getId());
            System.out.println("Nombre: " + product.getName());
            System.out.println("Precio: " + product.getPrice());
            System.out.println("Descripción: " + product.getDescription());
            System.out.println("----------------------------------------");
        }
    }
}