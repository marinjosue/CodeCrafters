package ec.edu.espe.view;

import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.model.Cart;
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
        Cart cart = new Cart();
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
                System.out.println("3. Carrito de compras");
                System.out.println("4. Atencion de usuario");
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
                        cart(hardwareStore, scanner);
                        break;
                    case 4:         
                        System.out.println("--- Datos del dueno ---");
                        System.out.println("Nombre: Daniel Maza");
                        System.out.println("Numero de telefono: 0995743691");
                        System.out.println("Email: modificaciones22@hotmail.com");
                                
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
            System.out.println("Stock:  " + product.getStock());
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
        hardwareStore.getCart();

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

        System.out.println("El precio con descuento del producto con ID " + productId + " es: " + product.getPrice());
    }

    private static Product findProductById(HardwareStore hardwareStore, int productId) {
        for (Product product : hardwareStore.getProductList()) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

private static void cart(HardwareStore hardwareStore, Scanner scanner) {
    System.out.println("---------- Carrito de Compras ----------");
    Cart cart = (Cart) hardwareStore.getCart();
    if (cart == null) {
        cart = new Cart();
        hardwareStore.setCart(cart);
    }

    boolean exit = false;
    while (!exit) {
        System.out.print("Ingrese el ID del producto que desea agregar al carrito (0 para finalizar): ");
        int productId = readInt(scanner);
        scanner.nextLine();

        if (productId == 0) {
            exit = true;
            continue;
        }

        Product product = findProductById(hardwareStore, productId);
        if (product == null) {
            System.out.println("Producto no encontrado.");
            continue;
        }

        if (product.getStock() == 0) {
            System.out.println("El producto seleccionado no esta disponible en stock.");
            continue;
        }

        cart.addProduct(product);
        product.setStock(product.getStock() - 1);  // Restar 1 al stock del producto
        System.out.println("Producto agregado al carrito.");
    }

    System.out.println("---------- Resumen de Compra ----------");
    for (Product product : cart.getProducts()) {
        System.out.println("ID: " + product.getId());
        System.out.println("Nombre: " + product.getName());
        System.out.println("Precio: " + product.getPrice());
        System.out.println("---------------------------------------");
    }

    System.out.println("Total de la factura: " + cart.getTotal());
}

    public static void main(String[] args) {
        run();
    }
}
