/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.view;

/**
 *
 * @author USER
 */

import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Product;

import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.List;

public class PromotionsMenu {
    public static void showPromotionsMenu(HardwareStore hardwareStore, Scanner scanner) {
        System.out.println("---------- Menú de Promociones ----------");
        System.out.println("1. Dueño: Aplicar descuento a un producto");
        System.out.println("2. Usuario: Ver precio con descuento de un producto");
        System.out.println("0. Volver");
        System.out.print("Ingrese la opción deseada: ");
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

    private static int readInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            scanner.nextLine(); // Consumir la entrada incorrecta
            return readInt(scanner); // Pedir de nuevo la entrada
        }
    }
}

