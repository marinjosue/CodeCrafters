package ec.edu.espe.hardwarestore.model;


public class Product {

    /**
     * @return the bornOnDate
     */
    /*public Date getBornOnDate() {
        return bornOnDate;
    }/*

    /**
     * @param bornOnDate the bornOnDate to set
     */
    /*public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }*/

    private String toolType;
    private String name;
    //private String color;
    //private int age;
    //private boolean isMolting;
    //private Date bornOnDate;

    public Product(String tooltype, String name) {
        this.toolType = tooltype;
        this.name = name;
        //this.color = color;
        //this.isMolting = isMolting;
        //this.bornOnDate = bornOnDate;
        //TODO CODE, Call method that computes the age
        //this.age = computeAge();
        //these methods are deprecated 
    }
    
/*public int computeAge() {
    Calendar now = Calendar.getInstance();
    Calendar bornOn = Calendar.getInstance();
    bornOn.setTime(bornOnDate);
    int age = now.get(Calendar.YEAR) - bornOn.get(Calendar.YEAR);
    if (now.get(Calendar.DAY_OF_YEAR) < bornOn.get(Calendar.DAY_OF_YEAR)) {
        age--;
    }
    return age;
}*/

    @Override
    public String toString() {
        return "Product{" + "Tool Type=" + toolType + ", Name Tool=" + name +  
                '}';
    }
    
    /**
     * @return the toolType
     */
    public String getId() {
        return toolType;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
