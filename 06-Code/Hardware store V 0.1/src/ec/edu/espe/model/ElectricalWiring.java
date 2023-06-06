/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.model;

/**
 *
 * @author Mesias Mariscal, Jeffrey Manobanda CodeCrafters; DCCO-ESPE
 */
public class ElectricalWiring {
    
    private String type;
    private String name;
    private float price;
    private String category;

    @Override
    public String toString() {
        return "ElectricalWiring{" + "type=" + type + ", name=" + name + ", price=" + price + ", category=" + category + '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ElectricalWiring(String type, String name, float price, String category) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
