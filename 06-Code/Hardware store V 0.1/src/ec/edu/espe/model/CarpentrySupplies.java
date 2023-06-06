package ec.edu.espe.model;

/**
 *
 * @author Mesias Mariscal, Jeffrey Manobanda CodeCrafters; DCCO-ESPE
 */
public class CarpentrySupplies {
    
    private String type;
    private String name;
    private float price;
    private String category;

    public CarpentrySupplies(String name, float price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
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

}
