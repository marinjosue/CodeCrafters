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

public class OwnerMenu {
    public static void showOwnerData(HardwareStore hardwareStore) {
        System.out.println("---------- Datos del Dueño ----------");
        System.out.println("Nombre de la Ferretería: " + hardwareStore.getName());
        System.out.println("Correo: " + hardwareStore.getEmail());
        System.out.println("Numero CI " + hardwareStore.getBatch());
        System.out.println("Numero telefonico: " + hardwareStore.getAmount());
        System.out.println("--------------------------------------");
    }
}

