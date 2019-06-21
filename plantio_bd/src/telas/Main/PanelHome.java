/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Main;

import telas.Manutencao.Defensivo;
import telas.Manutencao.Lavoura;
import telas.Manutencao.Planta;

/**
 *
 * @author itzfeltrin
 */
public class PanelHome extends javax.swing.JPanel {

    private String username;
    /**
     * Creates new form PanelAfterLogin
     * @param nome
     */
    public PanelHome(String nome) {
        initComponents();
        this.username = nome;
        lblLogText.setText("Logged in as " + this.username);        
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblLogText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAddLavoura = new javax.swing.JButton();
        btnGerLavoura = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        addDefensivo = new javax.swing.JButton();
        gerDefensivo = new javax.swing.JButton();
        gerPlanta = new javax.swing.JButton();
        addPlanta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        jLabel1.setText("jLabel1");

        setLayout(null);

        lblLogText.setFont(new java.awt.Font("Trebuchet MS", 3, 12)); // NOI18N
        lblLogText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(lblLogText);
        lblLogText.setBounds(340, 20, 350, 39);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel2.setText("Lavoura");
        add(jLabel2);
        jLabel2.setBounds(20, 30, 85, 40);

        btnAddLavoura.setText("Adicionar");
        btnAddLavoura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLavouraActionPerformed(evt);
            }
        });
        add(btnAddLavoura);
        btnAddLavoura.setBounds(140, 30, 90, 40);

        btnGerLavoura.setText("Gerenciar");
        btnGerLavoura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerLavouraActionPerformed(evt);
            }
        });
        add(btnGerLavoura);
        btnGerLavoura.setBounds(240, 30, 90, 40);
        add(jSeparator1);
        jSeparator1.setBounds(-30, 200, 830, 10);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel3.setText("Defensivo");
        add(jLabel3);
        jLabel3.setBounds(20, 130, 180, 40);

        addDefensivo.setText("Adicionar");
        addDefensivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDefensivoActionPerformed(evt);
            }
        });
        add(addDefensivo);
        addDefensivo.setBounds(140, 130, 90, 40);

        gerDefensivo.setText("Gerenciar");
        gerDefensivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerDefensivoActionPerformed(evt);
            }
        });
        add(gerDefensivo);
        gerDefensivo.setBounds(240, 130, 90, 40);

        gerPlanta.setText("Gerenciar");
        gerPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerPlantaActionPerformed(evt);
            }
        });
        add(gerPlanta);
        gerPlanta.setBounds(240, 230, 90, 40);

        addPlanta.setText("Adicionar");
        addPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlantaActionPerformed(evt);
            }
        });
        add(addPlanta);
        addPlanta.setBounds(140, 230, 90, 40);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel4.setText("Planta");
        add(jLabel4);
        jLabel4.setBounds(20, 230, 180, 40);
        add(jSeparator2);
        jSeparator2.setBounds(0, 90, 720, 10);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddLavouraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLavouraActionPerformed
        Lavoura lav = new Lavoura(null, true);
        lav.setVisible(true);
        lav.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAddLavouraActionPerformed

    private void btnGerLavouraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerLavouraActionPerformed
        telas.Listagem.ListagemLavoura lav = new telas.Listagem.ListagemLavoura(null, true);
        lav.setVisible(true);
        lav.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnGerLavouraActionPerformed

    private void addDefensivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDefensivoActionPerformed
        Defensivo def = new Defensivo(null, true);
        def.setLocationRelativeTo(null);
        def.setVisible(true);        
    }//GEN-LAST:event_addDefensivoActionPerformed

    private void gerDefensivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerDefensivoActionPerformed
        telas.Listagem.ListagemDefensivo def = new telas.Listagem.ListagemDefensivo(null, true);
        def.setVisible(true);
        def.setLocationRelativeTo(null);
    }//GEN-LAST:event_gerDefensivoActionPerformed

    private void gerPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerPlantaActionPerformed
        telas.Listagem.ListagemPlanta pla = new telas.Listagem.ListagemPlanta(null, true);
        pla.setVisible(true);
        pla.setLocationRelativeTo(null);
    }//GEN-LAST:event_gerPlantaActionPerformed

    private void addPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlantaActionPerformed
        Planta pla = new Planta(null, true);
        pla.setLocationRelativeTo(null);
        pla.setVisible(true);        
    }//GEN-LAST:event_addPlantaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDefensivo;
    private javax.swing.JButton addPlanta;
    private javax.swing.JButton btnAddLavoura;
    private javax.swing.JButton btnGerLavoura;
    private javax.swing.JButton gerDefensivo;
    private javax.swing.JButton gerPlanta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblLogText;
    // End of variables declaration//GEN-END:variables
}

