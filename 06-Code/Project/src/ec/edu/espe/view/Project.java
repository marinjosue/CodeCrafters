
package ec.edu.espe.view;

/**
 *
 * @author USER
 */

import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Navigation;
import ec.edu.espe.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        HardwareStore hardwareStore = createHardwareStore();


        JSONDataManager jsonDataManager = new JSONDataManager();


        jsonDataManager.saveData(hardwareStore);


        HardwareStore loadedHardwareStore = jsonDataManager.loadData();

        Navigation navigation = new Navigation();
        navigation.showMainMenu();
    }

    private static HardwareStore createHardwareStore() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos de la ferretería:");
        System.out.print("ID: ");
        int id = 01;
        scanner.nextLine(); 

        System.out.print("Nombre: ");
        String name = "Mi ferreteria";

        System.out.print("Lote: ");
        int batch = scanner.nextInt();

        System.out.print("Cantidad: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Email: ");
        String email = scanner.nextLine();

        List<Product> productList = new ArrayList<>();

        System.out.println("Ingrese los datos de los productos (Ingrese '0' para terminar):");
        boolean finished = false;
        while (!finished) {
            System.out.print("ID del producto: ");
            int productId = scanner.nextInt();
            scanner.nextLine();

            if (productId == 0) {
                finished = true;
                continue;
            }

            System.out.print("Nombre del producto: ");
            String productName = scanner.nextLine();

            System.out.print("Stock del producto: ");
            int stock = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Precio del producto: ");
            float price = scanner.nextFloat();
            scanner.nextLine(); 

            System.out.print("Descripción del producto: ");
            String description = scanner.nextLine();

            Product product = new Product(productId, productName, stock, price, description, null);
            productList.add(product);
        }

        return new HardwareStore(id, name, batch, amount, productList, email);
    }
}
