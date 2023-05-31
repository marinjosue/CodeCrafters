package ec.edu.espe.hardwarestore.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Tooltype> toolType;
    private Scanner scanner;

    public Menu(List<Tooltype> tooltype) {
        this.toolType = tooltype;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Add Tool Type");
            System.out.println("2. Add Product");
            System.out.println("3. Save and exit");
            System.out.println("4. Show information");
            System.out.println("5. Delete product");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Add toolType
                    System.out.print("Enter Tool Type: ");
                    String tooltype = scanner.next();
                    Tooltype toolType = new Tooltype(tooltype, new ArrayList<>());
                    toolType.equals(exit);
                    break;

                case 2:
                    // Add chicken
                    System.out.print("Enter Tool Type: ");
                    String tooltypeName = scanner.next();
                    Tooltype selectedCoop = null;
                    for (Tooltype c : Tooltype) {
                        if (c.getTooltype().equals(tooltypeName)) {
                            selectedCoop = c;
                            break;
                        }
                    }
                    if (selectedCoop == null) {
                        System.out.println("Not found");
                        break;
                    }
                    System.out.print("Enter name Tool Type: ");
                    int Productname = scanner.nextInt();
                    System.out.print("Enter name product: ");
                    String name = scanner.next();
                    //System.out.print("Enter chicken color: ");
                    //String color = scanner.next();
                    //System.out.print("Is chicken molting (true/false): ");
                    //boolean isMolting = scanner.nextBoolean();
                    //System.out.print("Enter chicken birth year: ");
                    //int year = scanner.nextInt();
                    //System.out.print("Enter chicken birth month: ");
                    //int month = scanner.nextInt();
                    //System.out.print("Enter chicken birth day: ");
                    //int day = scanner.nextInt();
                    //Product products = new Product(Productname);
                    //System.out.println("Product added: " + chicken.getName() + ");
                    //selectedCoop.getProducts().add(products);
                    break;


                case 3:
                    exit = true;
                    break;
                case 4:
                    for (Tooltype c : toolType) {
                        System.out.println(" Tool Typr: " + c.getTooltype());
                        for (Product ch : c.getProducts()) {
                            System.out.println( ch);
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                     System.out.print("Enter Tool Type: ");
                     String coopIdToDeleteFrom = scanner.next();
                     Tooltype selectedCoopToDeleteFrom = null;
                     for (Tooltype c : toolType) {
                         if (c.getTooltype().equals(coopIdToDeleteFrom)) {
                             selectedCoopToDeleteFrom = c;
                             break;
                         }
                     }
                     if (selectedCoopToDeleteFrom == null) {
                         System.out.println("Not found");
                         break;
                     }
                     System.out.print("Enter Tool Typr: ");
                     int chickenIdToDelete = scanner.nextInt();
                     Product chickenToDelete = null;
                     for (Product ch : selectedCoopToDeleteFrom.getProducts()) {
                         if (ch.getName()==ProductNameToDelete) {
                             chickenToDelete = ch;
                             break;
                         }
                     }
                     if (chickenToDelete == null) {
                         System.out.println("Not found");
                         break;
                     }
                     selectedCoopToDeleteFrom.getProducts().remove(chickenToDelete);
                     System.out.println("Product deleted");
                     break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
