/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Unit.Test;

/**
 *
 * @author jnman
 */
public class IVA {
    public static float calculateIVA(float number, float iva) {
        float price = number * iva;
        float totalprice = price + number;
        return totalprice;
    }   
    
}
