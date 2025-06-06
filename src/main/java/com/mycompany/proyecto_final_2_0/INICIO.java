/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto_final_2_0;
import javax.swing.*;
//librerias extras para limpiarArchivo
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class INICIO extends javax.swing.JFrame {

    /**
     * Creates new form INICIO
     */
    public INICIO() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        //limpiarArchivoPuntajes();    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAuto = new javax.swing.JButton();
        btnManual = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuReporte = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1260, 700));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAuto.setBackground(new java.awt.Color(79, 60, 43));
        btnAuto.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnAuto.setForeground(new java.awt.Color(255, 255, 255));
        btnAuto.setText("JUGAR MODO AUTOMÁTICO");
        btnAuto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAuto.setBorderPainted(false);
        btnAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 270, 80));

        btnManual.setBackground(new java.awt.Color(79, 60, 43));
        btnManual.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        btnManual.setForeground(new java.awt.Color(255, 255, 255));
        btnManual.setText("JUGAR MODO MANUAL");
        btnManual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManual.setFocusPainted(false);
        btnManual.setOpaque(true);
        btnManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManualActionPerformed(evt);
            }
        });
        jPanel1.add(btnManual, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 270, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo_inicio.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        menuBar.setBackground(new java.awt.Color(255, 204, 204));
        menuBar.setPreferredSize(new java.awt.Dimension(905, 23));

        jMenu1.setText("ACCIONES");

        menuReporte.setText("REPORTE DE JUGADORES");
        menuReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteActionPerformed(evt);
            }
        });
        jMenu1.add(menuReporte);

        menuAyuda.setText("AYUDA");
        menuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAyudaActionPerformed(evt);
            }
        });
        jMenu1.add(menuAyuda);

        menuSalir.setText("SALIR");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManualActionPerformed
        INICIO_MANUAL obj = new INICIO_MANUAL(this);
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnManualActionPerformed

    private void btnAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoActionPerformed
        INICIO_AUTO obj = new INICIO_AUTO(this);
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAutoActionPerformed

    private void menuReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteActionPerformed
        REPORTE_JUGADORES obj = new REPORTE_JUGADORES(this);
        obj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuReporteActionPerformed

    private void menuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAyudaActionPerformed
        AYUDA obj = new AYUDA(this);
        obj.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_menuAyudaActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed
    
    /*public void limpiarArchivoPuntajes() {
        try (PrintWriter pw = new PrintWriter("jugadores.txt")) {
            // No escribas nada. Solo abrir con PrintWriter vacía el archivo.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuto;
    private javax.swing.JButton btnManual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuReporte;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
}
