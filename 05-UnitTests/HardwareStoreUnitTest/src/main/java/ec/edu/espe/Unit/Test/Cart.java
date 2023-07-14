/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Unit.Test;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class Cart {
    public static float Cart(float[] precios) {
        float suma = 0.0f;

        for (float precio : precios) {
            suma += precio;
        }

        return suma;
    }   
}
