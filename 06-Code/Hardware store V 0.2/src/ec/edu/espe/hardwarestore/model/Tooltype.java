package ec.edu.espe.hardwarestore.model;

import java.util.ArrayList;

public class Tooltype {

    private String tooltype;
    private ArrayList<Product> products;

    @Override
    public String toString() {
        return "Tool Type{" + "type=" + tooltype + ", products=" + products + '}';
    }

    public Tooltype(String tooltype, ArrayList<Product> products) {
        this.tooltype = tooltype;
        this.products = products;
    }

    public String getTooltype() {
        return tooltype;
    }

    public void setTooltype(String tooltype) {
        this.tooltype = tooltype;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}