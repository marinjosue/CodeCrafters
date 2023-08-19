/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.controller;

import java.awt.*;
import java.awt.print.*;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */

public class PrintController implements Printable {
    private JPanel panelGrafico;

    public PrintController(JPanel panelGrafico) {
        this.panelGrafico = panelGrafico;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        
        Graphics2D g2d = (Graphics2D) graphics;
        panelGrafico.print(g2d);
        return Printable.PAGE_EXISTS;
    }
}






