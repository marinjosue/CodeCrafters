/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.Unit.Test;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class discount {
    public static float calcularPorcentajeDescuento(float precioOriginal, float precioDescuento) {
        if (precioOriginal <= 0 || precioDescuento <= 0) {
            throw new IllegalArgumentException("Los precios deben ser mayores que cero.");
        }

        float descuento = precioOriginal - precioDescuento;
        float porcentajeDescuento = (descuento / precioOriginal) * 100;

        return porcentajeDescuento;
    }
}
