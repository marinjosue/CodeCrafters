
package ec.edu.espe.model;

/**
 *
 * @author USER
 */
import java.util.List;

import java.util.List;

public class HardwareStore {
    private int id;
    private String name;
    private int batch;
    private int amount;
    private List<Product> productList;
    private String email;

    public HardwareStore(int id, String name, int batch, int amount, List<Product> productList, String email) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.amount = amount;
        this.productList = productList;
        this.email = email;
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
}
