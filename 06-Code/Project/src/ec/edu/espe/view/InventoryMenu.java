
package ec.edu.espe.view;

import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InventoryMenu {
    public static HardwareStore enterInventoryData(HardwareStore hardwareStore, Scanner scanner) {
        System.out.println("Ingrese los datos del inventario:");

        // ID:
        int id = 01;


        // Nombre del propietario:
        String name = "Daniel Masa";


        // Numero telefónico:
        int amount = 997232172;


        // Email:
        String email = "modificaciones22@hotmail.com";


        List<Product> productList = new ArrayList<>();

        System.out.println("Ingrese los datos de los productos (Ingrese '0' para terminar):");
        boolean finished = false;
        while (!finished) {
            System.out.print("ID del producto (numeros unicos): ");
            int productId = readInt(scanner);
            scanner.nextLine();

            if (productId == 0) {
                finished = true;
                continue;
            }

            System.out.print("Nombre del producto: ");
            String productName = scanner.nextLine();

            System.out.print("Stock del producto: ");
            int stock = readInt(scanner);
            scanner.nextLine();

            System.out.print("Precio del producto (0.000): ");
            float price = readFloat(scanner);
            scanner.nextLine();

            System.out.print("Descripcion del producto: ");
            String description = scanner.nextLine();

            Product product = new Product(productId, productName, stock, price, description, null);
            productList.add(product);
        }

        hardwareStore.setProductList(productList);
        return hardwareStore;
    }

    private static int readInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero entero.");
            scanner.nextLine(); // Consumir la entrada incorrecta
            return readInt(scanner); // Pedir de nuevo la entrada
        }
    }

    private static float readFloat(Scanner scanner) {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero decimal valido.");
            scanner.nextLine(); // Consumir la entrada incorrecta
            return readFloat(scanner); // Pedir de nuevo la entrada
        }
    }
}

