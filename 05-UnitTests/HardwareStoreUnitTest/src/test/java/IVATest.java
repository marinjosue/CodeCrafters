/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import ec.edu.espe.Unit.Test.IVA;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jnman
 */
public class IVATest {
    
    public IVATest() {
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

    @Test
    public void  testCalcularIva() {
        System.out.println("calcularIva");
        float priceproduct = 1.0F;
        float priceiva =  0.12F;
        float expResult =  1.12F;
        float result = IVA.calculateIVA(priceproduct,priceiva);
        assertEquals(expResult, result);
    }
}
