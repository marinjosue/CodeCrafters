
package com.mycompany.project;

import ec.edu.espe.controller.JSONDataManager;
import ec.edu.espe.controller.SaveComments;
import ec.edu.espe.model.Cart;
import ec.edu.espe.model.Comment;
import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Josue Marin, CodeCrafters: DCCO-ESPE
 */
public class Costomer {
    
   static void showUserMenu(HardwareStore hardwareStore, Scanner scanner) {
        
        boolean exit = false;
        while (!exit) {
            clearScreen();
            System.out.println("---------- Menu de Usuario ----------");
            System.out.println("1. Ver Catalogo");
            System.out.println("2. Mostrar promociones y ofertas");
            System.out.println("3. Carrito de compras");
            System.out.println("4. Atencion al usuario");
            System.out.println("5. Dejar Comentarios");
            System.out.println("0. Salir");
            System.out.print("Ingrese la opcion deseada: ");
            int option = readInt(scanner);
            scanner.nextLine();

            switch (option) {
                case 1:
                    showProductList(hardwareStore.getProductList());
                    break;
                case 2:
                    System.out.println("----Promociones de usuario-----");
                     Owner.showDiscountedPrice(hardwareStore, scanner);
                    break;
                case 3:
                    cart(hardwareStore, scanner);
                    break;
                case 4:
                    showContactInfo();
                    break;
                case 5:
                    leaveComment(scanner);
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

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static int readInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero entero.");
            scanner.nextLine();
            return readInt(scanner);
        }
    }
private static void showProductList(List<Product> productList) {
    clearScreen();
    System.out.println("---------- Lista de Productos ----------");
    JSONDataManager jsonDataManager = new JSONDataManager();
    HardwareStore existingHardwareStore = jsonDataManager.loadData();
    List<Product> existingProductList = existingHardwareStore.getProductList();

    for (Product product : existingProductList) {
        System.out.println("ID: " + product.getId());
        System.out.println("Nombre: " + product.getName());
        System.out.println("Precio: " + product.getPrice());
        System.out.println("Stock:  " + product.getStock());
        System.out.println("Descripcion: " + product.getDescription());
        System.out.println("----------------------------------------");
    }

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

private static void cart(HardwareStore hardwareStore, Scanner scanner) {
    clearScreen();
    System.out.println("---------- Carrito de Compras ----------");
    Cart cart = hardwareStore.getCart();
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

        JSONDataManager jsonDataManager = new JSONDataManager();
        HardwareStore existingHardwareStore = jsonDataManager.loadData();
        Product product = findProductById(existingHardwareStore, productId);
        if (product == null) {
            System.out.println("Producto no encontrado.");
            continue;
        }

        if (product.getStock() == 0) {
            System.out.println("El producto seleccionado no esta disponible en stock.");
            continue;
        }

        cart.addProduct(product);
        product.setStock(product.getStock() - 1);
        System.out.println("Producto agregado al carrito.");
    }
    
    double total = cart.getTotal();
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    String formattedTotal = decimalFormat.format(total);

    System.out.println("---------- Resumen de Compra ----------");
    for (Product product : cart.getProducts()) {
        System.out.println("ID: " + product.getId());
        System.out.println("Nombre: " + product.getName());
        System.out.println("Precio: " + product.getPrice());
        System.out.println("---------------------------------------");
    }

    System.out.println("Total de la factura: " + formattedTotal);
    System.out.println("Presione Enter para continuar...");
    try {
        System.in.read();
    } catch (IOException e) {
    }
}
private static List<Comment> comments = new ArrayList<>();

private static void leaveComment(Scanner scanner) {
    clearScreen();
    System.out.println("---------- Dejar Comentario ----------");
    System.out.print("Ingrese su nombre: ");
    String name = scanner.nextLine();
    System.out.print("Ingrese su comentario: ");
    String content = scanner.nextLine();

    Comment comment = new Comment(name, content);
    comments.add(comment);
    SaveComments.save(comments);

    System.out.println("Comentario agregado con exito.");
    System.out.println("Presione Enter para continuar...");
    try {
        System.in.read();
    } catch (IOException e) {
    }
}
    static void showComments() {
        clearScreen();
        System.out.println("---------- Comentarios ----------");
        List<Comment> comments = SaveComments.load();
        if (comments.isEmpty()) {
            System.out.println("No hay comentarios disponibles.");
        } else {
            for (Comment comment : comments) {
                System.out.println("Nombre: " + comment.getName());
                System.out.println("Comentario: " + comment.getContent());
                System.out.println("----------------------------------------");
            }
        }
    }
    private static void showContactInfo() {
        clearScreen();
        System.out.println("---------- Atencion al Usuario ----------");
        System.out.println("Si tiene alguna pregunta o necesita asistencia, puede contactarnos en los siguientes numeros:");
        System.out.println("Telefono: 0991267695");
        System.out.println("Correo Electronico: contacto@ferreteriadsa.com");
        System.out.println("Presione Enter para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
        }
}
}
