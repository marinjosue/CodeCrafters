package ec.edu.espe.model;

import java.util.ArrayList;

/**
 *
 * @author Mesias Mariscal,josue marin CodeCrafters; DCCO-ESPE
 */
public class HandTools {
private String name;
private float price;
private String description;


    public HandTools(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
      
    
    
}
