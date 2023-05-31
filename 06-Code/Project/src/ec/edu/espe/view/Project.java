
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
        // Crear una instancia de JSONDataManager
        JSONDataManager jsonDataManager = new JSONDataManager();

        // Leer los datos de hardwareStore desde un archivo JSON
        HardwareStore hardwareStore = jsonDataManager.loadData();

        // Mostrar el menú principal
        showMainMenu(hardwareStore);
    }

    private static void showMainMenu(HardwareStore hardwareStore) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("---------- Menú Principal ----------");
            System.out.println("1. Ingresar datos del inventario");
            System.out.println("2. Mostrar datos al usuario");
            System.out.println("3. Mostrar promociones y ofertas");
            System.out.println("4. Atención al usuario");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opción deseada: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer

            switch (option) {
                case 1:
                    // Ingresar datos del inventario
                    hardwareStore = enterInventoryData(hardwareStore);
                    break;
                case 2:
                    // Mostrar datos al usuario
                    showUserData(hardwareStore);
                    break;
                case 3:
                    // Mostrar promociones y ofertas
                    showPromotions();
                    break;
                case 4:
                    // Atención al usuario
                    showOwnerData(hardwareStore);
                    break;
                case 0:
                    // Salir
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }

            System.out.println("------------------------------------");
        }
    }

 private static HardwareStore enterInventoryData(HardwareStore hardwareStore) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del inventario:");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        hardwareStore.setId(id);

        scanner.nextLine(); // Limpiar el búfer

        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        hardwareStore.setName(name);

        System.out.print("Lote: ");
        int batch = scanner.nextInt();
        hardwareStore.setBatch(batch);

        System.out.print("Cantidad: ");
        int amount = scanner.nextInt();
        hardwareStore.setAmount(amount);

        scanner.nextLine(); // Limpiar el búfer

        System.out.print("Email: ");
        String email = scanner.nextLine();
        hardwareStore.setEmail(email);

        System.out.println("Datos del inventario actualizados.");
        
         List<Product> productList = new ArrayList<>();

        System.out.println("Ingrese los datos de los productos (Ingrese '0' para terminar):");
        boolean finished = false;
        while (!finished) {
            System.out.print("ID del producto: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer

            if (productId == 0) {
                finished = true;
                continue;
            }

            System.out.print("Nombre del producto: ");
            String productName = scanner.nextLine();

            System.out.print("Stock del producto: ");
            int stock = scanner.nextInt();
            scanner.nextLine(); // Limpiar el búfer

            System.out.print("Precio del producto: ");
            float price = scanner.nextFloat();
            scanner.nextLine(); // Limpiar el búfer

            System.out.print("Descripción del producto: ");
            String description = scanner.nextLine();

            Product product = new Product(productId, productName, stock, price, description, null);
            productList.add(product);
        }
        return new HardwareStore(id, name, batch, amount, productList, email);

    }

    private static void showUserData(HardwareStore hardwareStore) {
        System.out.println("---------- Datos al Usuario ----------");
        System.out.println("ID: " + hardwareStore.getId());
        System.out.println("Nombre de la Ferretería: " + hardwareStore.getName());
        System.out.println("Lote: " + hardwareStore.getBatch());
        System.out.println("Cantidad: " + hardwareStore.getAmount());
        System.out.println("Email: " + hardwareStore.getEmail());
        System.out.println("---------------------------------------");
    }

    private static void showPromotions() {
        // Agregar lógica para mostrar promociones y ofertas
        System.out.println("Mostrando promociones y ofertas...");
    }

    private static void showOwnerData(HardwareStore hardwareStore) {
        System.out.println("---------- Datos del Dueño ----------");
        System.out.println("Nombre de la Ferretería: " + hardwareStore.getName());
        System.out.println("Correo: " + hardwareStore.getEmail());
        System.out.println("--------------------------------------");
    }
}