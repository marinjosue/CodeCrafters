/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.controller;

/**
 *
 * @author Mesias Mariscal, CodeCrafters; DCCO-ESPE
 */
public class User {

    private String nombres;
    private String apellidos;
    private String direccion;
    private String CI;
    private String email;

    public User(String nombres, String apellidos, String direccion, String CI, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.CI = CI;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getCI() {
        return CI;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }
}

