package com.mycompany.project;

import com.mycompany.project.Costomer;
import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import ec.edu.espe.controller.JSONDataManager;

/**
 * Author: Josue Marin, CodeCrafters: DCCO-ESPE
 */
public class Owner {
    public static final String OWNER_PASSWORD = "edison2";
    
  
    static void showOwnerMenu(HardwareStore hardwareStore, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
           Costomer.clearScreen();
            System.out.println("---------- Menu de Propietario ----------");
            System.out.println("1. Ingresar productos al inventario");
            System.out.println("2. Agregar promociones y ofertas");
            System.out.println("3. Verificar Stock de los Productos");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opcion deseada: ");
            int option = Costomer.readInt(scanner);
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    hardwareStore = enterInventoryData(hardwareStore, scanner);
                    break;
                case 2:
                    showPromotionsMenu(hardwareStore, scanner);
                    break;
                case 3:
                    verificarStock(hardwareStore.getProductList());
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }
        }
    }

 
   static HardwareStore enterInventoryData(HardwareStore hardwareStore, Scanner scanner) {
    System.out.println("Ingrese los datos del inventario:");
    List<Product> productList = new ArrayList<>();
    
    boolean finished = false;
    while (!finished) {
        System.out.print("ID del producto (numeros unicos): ");
        int productId = Costomer.readInt(scanner);
        scanner.nextLine();
        if (productId == 0) {
            finished = true;
            break;
        }
        
        if (ProductValidator.isProductExists(hardwareStore, productId)) {
            System.out.println("Error. El producto con ID " + productId + " ya existe.");
            continue;
        }
        
        System.out.print("Nombre del producto: ");
        String productName = scanner.nextLine();

        System.out.print("Stock del producto: ");
        int stock = Costomer.readInt(scanner);
        scanner.nextLine();

        System.out.print("Precio del producto (0.00): ");
        float price = readFloat(scanner);
        scanner.nextLine();

        System.out.print("Descripcion del producto: ");
        String description = scanner.nextLine();

        Product product = new Product(productId, productName, stock, (int) price, description);
        productList.add(product);

        System.out.print("Desea continuar agregando productos? (1 para si / 0 para no): ");
        int choice = Costomer.readInt(scanner);
        scanner.nextLine();
        if (choice == 0) {
            finished = true;
        }
    }

    hardwareStore.setProductList(productList);
    JSONDataManager jsonDataManager = new JSONDataManager();
    jsonDataManager.saveData(hardwareStore);
  return hardwareStore;
}

    static void showPromotionsMenu(HardwareStore hardwareStore, Scanner scanner) {
        boolean exit = false;
                    
        while (!exit) {
            Costomer.clearScreen();
            System.out.println("---------- Menu de Promociones ----------");
            System.out.println("1. Aplicar descuento a un producto");
            System.out.println("0. Volver");
            System.out.print("Ingrese la opcion deseada: ");
            int option = Costomer.readInt(scanner);
            scanner.nextLine();

            switch (option) {
                case 1:
                    applyDiscount(hardwareStore, scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente nuevamente.");
                    break;
            }
        }
    }
static void verificarStock(List<Product> productList) {
        boolean allInStock = true;
        for (Product product : productList) {
            if (product.getStock() == 0) {
                System.out.println("ADVERTENCIA: " + product.getName() + " con ID " + product.getId() + " esta agotado.");
                allInStock = false;
            }
        }

        if (allInStock) {
            System.out.println("Todos los productos estan en stock.");
        }

        System.out.println("Presione Enter para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
        }
}

private static void applyDiscount(HardwareStore hardwareStore, Scanner scanner) {
    Costomer.clearScreen();
    JSONDataManager jsonDataManager = new JSONDataManager();
    HardwareStore existingHardwareStore = jsonDataManager.loadData();
       
    System.out.print("Ingrese el ID del producto al que desea aplicar descuento: ");
    int productId = Costomer.readInt(scanner);
    scanner.nextLine();

    Product product = findProductById(existingHardwareStore, productId);
    if (product == null) {
        System.out.println("Producto no encontrado.");
        return;
    }
    System.out.print("Ingrese el porcentaje de descuento (0-100): ");
    int discountPercentage = Costomer.readInt(scanner);
    scanner.nextLine();

    float discountedPrice = product.getPrice() * (1 - (discountPercentage / 100.0f));
    product.setPrice(discountedPrice);
    product.setDiscountPercentage(discountPercentage);

    System.out.println("Descuento aplicado al producto con ID " + productId + ".");
    System.out.println("El nuevo precio del producto es: " + discountedPrice);
    System.out.println("Presione Enter para continuar...");
    try {
        System.in.read();
    } catch (IOException e) {
    }
}

static void showDiscountedPrice(HardwareStore hardwareStore, Scanner scanner) {
    Costomer.clearScreen();

    JSONDataManager jsonDataManager = new JSONDataManager();
    HardwareStore existingHardwareStore = jsonDataManager.loadData();
    
    System.out.print("Ingrese el ID del producto para ver el precio con descuento: ");
    int productId = Costomer.readInt(scanner);
    scanner.nextLine();

    Product product = findProductById(existingHardwareStore, productId);
    if (product == null) {
        System.out.println("Producto no encontrado.");
        return;
    }

    double discountedPrice = product.getPrice() * (1 - (product.getDiscountPercentage() / 100.0));
    System.out.println("El precio con descuento del producto con ID " + productId + " es: " + discountedPrice);
    System.out.println("Presione Enter para continuar...");
    try {
        System.in.read();
    } catch (IOException e) {
    }
}
     private static Product findProductById(HardwareStore hardwareStore, int productId) {
        for (Product product : hardwareStore.getProductList()) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
    private static float readFloat(Scanner scanner) {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida.Por favor, ingrese un numero decimal valido.");
            scanner.nextLine();
            return readFloat(scanner);
        }
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
