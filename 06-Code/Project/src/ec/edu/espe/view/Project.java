package ec.edu.espe.view;

import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Project {
    public static void run() {
        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore hardwareStore = jsonDataManager.loadData();
        showMainMenu(hardwareStore);
    }

    private static void showMainMenu(HardwareStore hardwareStore) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {

            System.out.println("---------- BIENVENIDO A FERRETERIA DSA ----------");
            System.out.println("DESEA INGRESAR COMO:");
            System.out.println("1.- PROPIETARIO");
            System.out.println("2.- USUARIO");
            System.out.print("Ingrese la opcion deseada: ");
            int op = readInt(scanner);
            if (op == 1) {
                System.out.println("1. Ingresar datos del inventario");
                System.out.println("2. Mostrar promociones y ofertas");
                System.out.println("0. Salir");
                System.out.print("Ingrese la opcion deseada: ");
                int option = readInt(scanner);
                scanner.nextLine();

              switch (option) {
                    case 1:
                        hardwareStore = enterInventoryData(hardwareStore, scanner);
                        break;
                    case 2:
                        showPromotionsMenu(hardwareStore, scanner);
                        break;
                    case 0:
                        exit = true;
                        break;
                     default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                        break; 
                }
            } else {

                System.out.println("1. Ver Catalogo");
                System.out.println("2. Mostrar promociones y ofertas");
                System.out.println("3. Atencion al usuario");
                System.out.println("0. Salir");
                System.out.print("Ingrese la opcion deseada: ");
                int option = readInt(scanner);
                scanner.nextLine();

                switch (option) {
                    case 1:
                        showProductList(hardwareStore.getProductList());
                        break;
                    case 2:
                        showPromotionsMenu(hardwareStore, scanner);
                        break;
                    case 3:
                        showOwnerData(hardwareStore);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                        break;
                }
            }

            System.out.println("------------------------------------");
        }
    }

    private static int readInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero entero.");
            scanner.nextLine();
            return readInt(scanner);
        }
    }

    private static float readFloat(Scanner scanner) {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero decimal valido.");
            scanner.nextLine();
            return readFloat(scanner);
        }
    } 

    private static HardwareStore enterInventoryData(HardwareStore hardwareStore, Scanner scanner) {
        System.out.println("Ingrese los datos del inventario:");

        int id = 1;
        hardwareStore.setId(id);

        String name = "Daniel Maza";

        int amount = 997232172;
        hardwareStore.setAmount(amount);

        String email = "modificaciones22@hotmail.com";
        hardwareStore.setEmail(email);
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

    private static void showProductList(List<Product> productList) {
        System.out.println("---------- Lista de Productos ----------");
        for (Product product : productList) {
            System.out.println("ID: " + product.getId());
            System.out.println("Nombre: " + product.getName());
            System.out.println("Precio: " + product.getPrice());
            System.out.println("Descripcion: " + product.getDescription());
            System.out.println("----------------------------------------");
        }
    }

    private static void showPromotionsMenu(HardwareStore hardwareStore, Scanner scanner) {
        System.out.println("---------- Menu de Promociones ----------");
        System.out.println("1. Dueno: Aplicar descuento a un producto");
        System.out.println("2. Usuario: Ver precio con descuento de un producto");
        System.out.println("0. Volver");
        System.out.print("Ingrese la opcion deseada: ");
        int option = readInt(scanner);
        scanner.nextLine();

        switch (option) {
            case 1:
                applyDiscount(hardwareStore, scanner);
                break;
            case 2:
                showDiscountedPrice(hardwareStore, scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
    }

    private static void applyDiscount(HardwareStore hardwareStore, Scanner scanner) {
        System.out.print("Ingrese el ID del producto al que desea aplicar descuento: ");
        int productId = readInt(scanner);
        scanner.nextLine();

        Product product = findProductById(hardwareStore, productId);
        if (product == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese el porcentaje de descuento (0-100): ");
        int discountPercentage = readInt(scanner);
        scanner.nextLine();

        float discountedPrice = product.getPrice() * (1 - (discountPercentage / 100.0f));
        product.setPrice(discountedPrice);

        System.out.println("Descuento aplicado al producto con ID " + productId + ".");
    }

    private static void showDiscountedPrice(HardwareStore hardwareStore, Scanner scanner) {
        System.out.print("Ingrese el ID del producto para ver el precio con descuento: ");
        int productId = readInt(scanner);
        scanner.nextLine();

        Product product = findProductById(hardwareStore, productId);
        if (product == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Precio con descuento del producto con ID " + productId + ": " + product.getPrice());
    }

    private static Product findProductById(HardwareStore hardwareStore, int productId) {
        for (Product product : hardwareStore.getProductList()) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    private static void showOwnerData(HardwareStore hardwareStore) {
        System.out.println("---------- Datos del Propietario ----------");
        System.out.println("Nombre: " + hardwareStore.getName());
        System.out.println("Cantidad de productos: " + hardwareStore.getAmount());
        System.out.println("Correo electronico: " + hardwareStore.getEmail());
        System.out.println("-------------------------------------------");
    }
}
