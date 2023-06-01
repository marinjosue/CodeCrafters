/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Josue Marin, CodeCrafters: DCCO-ESPE
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private ArrayList<Object> list;

    public Inventory() {
        list = new ArrayList<>();
    }

    public void addItems() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter BuildingMaterials name, price, and category:");
        String bmName = scanner.nextLine();
        float bmPrice = scanner.nextFloat();
        scanner.nextLine();
        String bmCategory = scanner.nextLine();
        BuildingMaterials bm = new BuildingMaterials(bmName, bmPrice, bmCategory);
        list.add(bm);

        System.out.println("Enter CarpentrySupplies name, price, and category:");
        String csName = scanner.nextLine();
        float csPrice = scanner.nextFloat();
        scanner.nextLine();
        String csCategory = scanner.nextLine();
        CarpentrySupplies cs = new CarpentrySupplies(csName, csPrice, csCategory);
        list.add(cs);

    }

    public void getList() {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
