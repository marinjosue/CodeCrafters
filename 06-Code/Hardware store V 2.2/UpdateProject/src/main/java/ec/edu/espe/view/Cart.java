
package ec.edu.espe.view;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.controller.*;
import ec.edu.espe.model.*;
import java.awt.*;
import java.awt.print.*;
import ec.edu.espe.controller.ProductController;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class Cart extends javax.swing.JFrame {
    FondoPanel fondo = new FondoPanel();
    private DatabaseConnection dbConnection;
    List<Product> cartProducts;
    private double totalPrice;
    /**
     * Creates new form Cart
     */
    public Cart() {
        dbConnection = new DatabaseConnection("products");
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        cartProducts = new ArrayList<>(); 
        ProductController productController = new ProductController(dbConnection.getCollection(), cartProducts, tableCart);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        panelGrafico = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbIVA = new javax.swing.JComboBox<>();
        txtci = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        txtadress = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnTotalPRice = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtIdCart = new javax.swing.JTextField();
        spnQuantity = new javax.swing.JSpinner();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Carrito de Compras");

        jLabel2.setText("Ingrese el ID del producto que desea comprar");

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Stock", "Precio", "Descripcion"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jButton1.setText("Mostrar Catalogo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        panelGrafico.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Total : $");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("FERRETERIA_DSA");

        jLabel5.setText("Iva: %");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Factura ");

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio unitario", "Cantidad", "Precio total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCart);

        jLabel9.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------");

        jLabel10.setText("ci:");

        jLabel11.setText("Email:");

        jLabel12.setText("Dirección:");

        jLabel13.setText("Fecha y Hora:");

        jLabel14.setText("Nombre:");

        cmbIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12%", "10%", "8%" }));

        txtci.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtciAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtemail.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtemailAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtName.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtNameAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtdate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtdateAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtadress.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtadressAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout panelGraficoLayout = new javax.swing.GroupLayout(panelGrafico);
        panelGrafico.setLayout(panelGraficoLayout);
        panelGraficoLayout.setHorizontalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelGraficoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)
                        .addComponent(cmbIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGraficoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
            .addGroup(panelGraficoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGraficoLayout.createSequentialGroup()
                        .addComponent(txtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addGap(448, 448, 448))
                    .addGroup(panelGraficoLayout.createSequentialGroup()
                        .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtci)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtadress, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelGraficoLayout.createSequentialGroup()
                .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGraficoLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel8))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(315, 315, 315))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGraficoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(288, 288, 288))))
            .addComponent(jScrollPane2)
        );
        panelGraficoLayout.setVerticalGroup(
            panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGraficoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(3, 3, 3)
                        .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGraficoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtadress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        btnTotalPRice.setText("Calcular precio total");
        btnTotalPRice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalPRiceActionPerformed(evt);
            }
        });

        jLabel15.setText("Ingrese la cantidad deseada");

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtIdCart, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(75, 75, 75))))
                                    .addComponent(btnExit)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jButton1)))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTotalPRice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(324, 324, 324))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd)
                                .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTotalPRice, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    MenuOwner addOfers = new MenuOwner();
        addOfers.setVisible(true);
        this.setVisible(false);      
    }//GEN-LAST:event_btnExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableController tableController = new TableController(dbConnection);
        jTable1.setModel(tableController.getTableModel());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ProductController productController = new ProductController(dbConnection.getCollection(), cartProducts, tableCart);
        productController.btnAddActionPerformed(evt, txtIdCart, spnQuantity);  
        double totalPriceWithVAT = productController.calculateTotalPriceWithVAT();
        txtPrice.setText(String.valueOf(totalPriceWithVAT));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnTotalPRiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalPRiceActionPerformed
        ProductController productController = new ProductController(dbConnection.getCollection(), cartProducts, tableCart);
        double totalPriceWithVAT = productController.calculateTotalPriceWithVAT();
        System.out.println("Total Price with VAT: " + totalPriceWithVAT);

        SwingUtilities.invokeLater(() -> {
            txtPrice.setText(String.valueOf(totalPriceWithVAT));
        });
    }//GEN-LAST:event_btnTotalPRiceActionPerformed

    private void txtNameAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtNameAncestorAdded
        User user = UserFinder.findUser(UserData.userCi);
        if (user != null) {
            String userName = user.getNombres();
            String userlastName = user.getApellidos();
            txtName.setText(userName +" "+ userlastName);
        }     
    }//GEN-LAST:event_txtNameAncestorAdded

    private void txtciAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtciAncestorAdded
        User user = UserFinder.findUser(UserData.userCi);
        if (user != null) {
            String ci = user.getCI();
            txtci.setText( ci);    
        }
    }//GEN-LAST:event_txtciAncestorAdded

    private void txtemailAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtemailAncestorAdded
         User user = UserFinder.findUser(UserData.userCi);
        if (user != null) {
            String email = user.getEmail();
            txtemail.setText( email);
        }
    }//GEN-LAST:event_txtemailAncestorAdded

    private void txtdateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtdateAncestorAdded
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        txtdate.setText(formattedDate);
    }//GEN-LAST:event_txtdateAncestorAdded

    private void txtadressAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtadressAncestorAdded
            User user = UserFinder.findUser(UserData.userCi);
        if (user != null) {
            String adress = user.getDireccion();
            txtadress.setText( adress);
        }
    }//GEN-LAST:event_txtadressAncestorAdded

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        PrintController printController = new PrintController(panelGrafico);
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(printController);
            
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImprimirActionPerformed
 
private void updateCartTable() {
    DefaultTableModel cartTableModel = (DefaultTableModel) tableCart.getModel();
    cartTableModel.setRowCount(0);
    double totalValue = 0.0;       
    for (Product product : cartProducts) {
        double quantity = product.getQuantity();
        double totalPrice = product.getPrice() * quantity;
        product.setTotalPrice((float) totalPrice);
        totalValue += totalPrice;
        Object[] row = { product.getId(), product.getName(), product.getPrice(), quantity, totalPrice };
        cartTableModel.addRow(row);
    }
    tableCart.setModel(cartTableModel);
    txtPrice.setText(String.valueOf(totalValue));
}
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnTotalPRice;
    private javax.swing.JComboBox<String> cmbIVA;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelGrafico;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tableCart;
    private javax.swing.JTextField txtIdCart;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtadress;
    private javax.swing.JTextField txtci;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables
   class FondoPanel extends JPanel
    {
        private Image imagen;
        @Override
        public void paint (Graphics g){            
            imagen = new ImageIcon(getClass().getResource("/Pictures/General.jpg")).getImage();
            g.drawImage(imagen,0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    
    } 
}
