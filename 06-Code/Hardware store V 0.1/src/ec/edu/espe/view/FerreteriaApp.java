package ec.edu.espe.view;
import ec.edu.espe.model.BuildingMaterials;
import ec.edu.espe.model.CarpentrySupplies;


import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FerreteriaApp {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter BuildingMaterials name, price, and category:");
        String bmName = scanner.nextLine();
        float bmPrice = scanner.nextFloat();
        scanner.nextLine();
        String bmCategory = scanner.nextLine();
        BuildingMaterials bm = new BuildingMaterials(bmName, bmPrice, bmCategory);
        list.add(bm);
        //
        System.out.println("Enter BuildingMaterials name, price, and category:");
        String bmName = scanner.nextLine();
        float bmPrice = scanner.nextFloat();
        scanner.nextLine();
        String bmCategory = scanner.nextLine();
        BuildingMaterials bm = new BuildingMaterials(bmName, bmPrice, bmCategory);
        list.add(bm);
        System.out.println("Enter BuildingMaterials name, price, and category:");
        String bmName = scanner.nextLine();
        float bmPrice = scanner.nextFloat();
        scanner.nextLine();
        String bmCategory = scanner.nextLine();
        BuildingMaterials bm = new BuildingMaterials(bmName, bmPrice, bmCategory);
        list.add(bm);
        //
        System.out.println("Enter CarpentrySupplies name, price, and category:");
        String csName = scanner.nextLine();
        float csPrice = scanner.nextFloat();
        scanner.nextLine();
        String csCategory = scanner.nextLine();
        CarpentrySupplies cs = new CarpentrySupplies(csName, csPrice, csCategory);
        list.add(cs);

        // Repeat the above process for the remaining 6 classes

        // Save the data to a JSON file
        saveData(list);

        // Print the list to verify its contents
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void saveData(ArrayList<Object> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);

        try (FileWriter writer = new FileWriter("datos.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
