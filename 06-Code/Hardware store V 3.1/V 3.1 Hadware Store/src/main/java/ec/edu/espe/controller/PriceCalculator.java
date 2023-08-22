/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.controller;

import javax.swing.JOptionPane;

/**
 *
 * @author Josue Marin, CodeCrafters: DCCO-ESPE
 */
public class PriceCalculator {
     public static double calculateTotalPriceWithVAT(String usePrice, String useIva) {
        try {
            double price = Double.parseDouble(usePrice);
            int iva = Integer.parseInt(useIva); 
            double ivat = price * (iva / 100.0); 
            double totalPriceWithVAT = price + ivat;
            return totalPriceWithVAT;
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese solo números en el campo Iva%", "Error", JOptionPane.ERROR_MESSAGE);
            return 0.0; 
        }
    }
}
