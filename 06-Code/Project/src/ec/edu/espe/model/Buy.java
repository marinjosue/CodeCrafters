
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

