package ec.edu.espe.view;


import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
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
            System.out.println("1.- USUARIO");
            System.out.println("2.- PROPIETARIO");
            System.out.print("Ingrese la opción deseada: ");
            int op = scanner.nextInt();
            if(op==1){
                System.out.println("1. Ingresar datos del inventario");
                System.out.println("2. Mostrar datos al usuario");
                System.out.println("3. Mostrar promociones y ofertas");
                System.out.println("4. Atención al usuario");
                System.out.println("0. Salir");
                System.out.print("Ingrese la opción deseada: ");
                int option = scanner.nextInt();
                scanner.nextLine(); 

            switch (option) {
                case 1:

                    hardwareStore = enterInventoryData(hardwareStore);
                    break;
                case 2:
                    showProductList(hardwareStore.getProductList());
                    break;
                case 3:
                    showPromotionsMenu(hardwareStore);
                    break;
                case 4:
                    showOwnerData(hardwareStore);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
            }else{
                System.out.println("1. Registrarse");
                System.out.println("2. Ver Catalogo");
                System.out.println("3. Mostrar promociones y ofertas");
                System.out.println("4. Atención al usuario");
                System.out.println("0. Salir");
                System.out.print("Ingrese la opción deseada: ");
                int option = scanner.nextInt();
                scanner.nextLine(); 

            switch (option) {
                case 1:

                    hardwareStore = enterInventoryData(hardwareStore);
                    break;
                case 2:
                    showProductList(hardwareStore.getProductList());
                    break;
                case 3:
                    showPromotionsMenu(hardwareStore);
                    break;
                case 4:
                    showOwnerData(hardwareStore);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
                
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

        scanner.nextLine();

        System.out.print("Nombre del propietario: ");
        String name = scanner.nextLine();
        hardwareStore.setName(name);

        System.out.print("Numero de CI: ");
        int batch = scanner.nextInt();
        hardwareStore.setBatch(batch);

        System.out.print("Numero telefonico: ");
        int amount = scanner.nextInt();
        hardwareStore.setAmount(amount);

        scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();
        hardwareStore.setEmail(email);

        System.out.println("Datos del inventario actualizados.");

        List<Product> productList = new ArrayList<>();

        System.out.println("Ingrese los datos de los productos (Ingrese '0' para terminar):");
        boolean finished = false;
        while (!finished) {
            System.out.print("ID del producto (numeros unicos): ");
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

            System.out.print("Precio del producto (0.000): ");
            float price = scanner.nextFloat();
            scanner.nextLine();

            System.out.print("Descripción del producto: ");
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
            System.out.println("Descripción: " + product.getDescription());
            System.out.println("----------------------------------------");
        }
    }


    private static void showPromotionsMenu(HardwareStore hardwareStore) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------- Menú de Promociones ----------");
        System.out.println("1. Dueño: Aplicar descuento a un producto");
        System.out.println("2. Usuario: Ver precio con descuento de un producto");
        System.out.println("0. Volver");
        System.out.print("Ingrese la opción deseada: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1:
                applyDiscount(hardwareStore);
                break;
            case 2:
                showDiscountedPrice(hardwareStore);
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
    }

    private static void applyDiscount(HardwareStore hardwareStore) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto al que desea aplicar descuento: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = findProductById(hardwareStore, productId);
        if (product == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese el porcentaje de descuento (0-100): ");
        int discountPercentage = scanner.nextInt();
        scanner.nextLine(); 
        
        float discountedPrice = product.getPrice() * (1 - (discountPercentage / 100.0f));
        product.setPrice(discountedPrice);

        System.out.println("Descuento aplicado al producto con ID " + productId + ".");
    }

    private static void showDiscountedPrice(HardwareStore hardwareStore) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del producto para ver el precio con descuento: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = findProductById(hardwareStore, productId);
        if (product == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.println("Precio del producto con descuento: " + product.getPrice());
    }

    private static Product findProductById(HardwareStore hardwareStore, int productId) {
        List<Product> productList = hardwareStore.getProductList();
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    private static void showOwnerData(HardwareStore hardwareStore) {
        System.out.println("---------- Datos del Dueño ----------");
        System.out.println("Nombre de la Ferretería: " + hardwareStore.getName());
        System.out.println("Correo: " + hardwareStore.getEmail());
        System.out.println("Numero CI " +hardwareStore.getBatch());
        System.out.println("Numero telefonico: "+ hardwareStore.getAmount());
        System.out.println("--------------------------------------");
    }
}