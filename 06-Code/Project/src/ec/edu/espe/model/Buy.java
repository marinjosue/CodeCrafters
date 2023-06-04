
package ec.edu.espe.model;

/**
 *
 * @author USER
 */
import java.util.Date;

public class Buy {
    private int id;
    private Date dateOfPurchase;
    private String listOfPurchase;
    private int purchaseRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getListOfPurchase() {
        return listOfPurchase;
    }

    public void setListOfPurchase(String listOfPurchase) {
        this.listOfPurchase = listOfPurchase;
    }

    public int getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(int purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    public Buy(int id, Date dateOfPurchase, String listOfPurchase, int purchaseRate) {
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.listOfPurchase = listOfPurchase;
        this.purchaseRate = purchaseRate;
    }

    public void generatePurchase() {

    }

    public void recordPurchaseDetails() {

    }
}

