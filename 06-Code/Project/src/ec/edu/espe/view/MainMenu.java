package ec.edu.espe.view;

import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void showMainMenu(HardwareStore hardwareStore) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("---------- BIENVENIDO A FERRETERIA DSA ----------");
            System.out.println("DESEA INGRESAR COMO:");
            System.out.println("1.- PROPIETARIO");
            System.out.println("2.- USUARIO");
            System.out.print("Ingrese la opción deseada: ");
            int op = readInt(scanner);

            if (op == 1) {
                showOwnerMenu(hardwareStore, scanner);
            } else {
                showUserMenu(hardwareStore, scanner);
            }

            System.out.println("------------------------------------");
        }
    }

    private static void showOwnerMenu(HardwareStore hardwareStore, Scanner scanner) {
        System.out.println("1. Ingresar datos del inventario");
        System.out.println("2. Mostrar promociones y ofertas");
        System.out.println("0. Salir");
        System.out.print("Ingrese la opción deseada: ");
        int option = readInt(scanner);
        scanner.nextLine();

        switch (option) {
            case 1:
                hardwareStore = InventoryMenu.enterInventoryData(hardwareStore, scanner);
                break;
            case 2:
                PromotionsMenu.showPromotionsMenu(hardwareStore, scanner);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
    }

    private static void showUserMenu(HardwareStore hardwareStore, Scanner scanner) {
        System.out.println("1. Ver Catálogo");
        System.out.println("2. Mostrar promociones y ofertas");
        System.out.println("3. Atención al usuario");
        System.out.println("0. Salir");
        System.out.print("Ingrese la opción deseada: ");
        int option = readInt(scanner);
        scanner.nextLine();

        switch (option) {
            case 1:
                ProductMenu.showProductList(hardwareStore.getProductList());
                break;
            case 2:
                PromotionsMenu.showPromotionsMenu(hardwareStore, scanner);
                break;
            case 3:
                OwnerMenu.showOwnerData(hardwareStore);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
    }

    private static int readInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            scanner.nextLine(); // Consumir la entrada incorrecta
            return readInt(scanner); // Pedir de nuevo la entrada
        }
    }

    private static float readFloat(Scanner scanner) {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número decimal válido.");
            scanner.nextLine(); // Consumir la entrada incorrecta
            return readFloat(scanner); // Pedir de nuevo la entrada
        }
    }
}
