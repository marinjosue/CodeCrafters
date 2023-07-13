
package com.mycompany.project;

import ec.edu.espe.model.HardwareStore;
import ec.edu.espe.model.Product;

/**
 *
 * @author Josue Marin, CodeCrafters: DCCO-ESPE
 */
public class ProductValidator {
    public static boolean isProductExists(HardwareStore hardwareStore, int productId) {
        for (Product product : hardwareStore.getProductList()) {
            if (product.getId() == productId) {
                return true;
            }
        }
        return false;
    }
}

