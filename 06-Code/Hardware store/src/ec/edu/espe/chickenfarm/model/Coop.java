package ec.edu.espe.chickenfarm.model;

import java.util.ArrayList;

/**
 *
 * @author Mesias Mariscal, Jsons, DCCO-ESPE
 */
public class Coop {

    private String id;
    private ArrayList<Chicken> chickens;

    @Override
    public String toString() {
        return "Coop{" + "id=" + id + ", chickens=" + chickens + '}';
    }

    public Coop(String id, ArrayList<Chicken> chickens) {
        this.id = id;
        this.chickens = chickens;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Chicken> getChickens() {
        return chickens;
    }

    public void setChickens(ArrayList<Chicken> chickens) {
        this.chickens = chickens;
    }

}