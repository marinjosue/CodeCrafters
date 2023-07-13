/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.Unit.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mesia
 */
public class discountTest {
    
    public discountTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of calcularPorcentajeDescuento method, of class discount.
     */
    @Test
    public void testCalcularPorcentajeDescuento() {
        System.out.println("calcularPorcentajeDescuento");
        float originalpricel =200.0F;
        float priceDiscount =  50.0F;
        float expResult =  100.0F;
        float result = discount.calcularPorcentajeDescuento(originalpricel, priceDiscount);
        assertEquals(expResult, result);
    }
    
}
