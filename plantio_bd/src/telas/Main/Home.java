/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Main;

import javax.swing.JOptionPane;
/**
 *
 * @author itzfeltrin
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Home() {
        try {            
            initComponents();            
            setResizable(false);
            setLocationRelativeTo(null);
            setTitle("Program");
            menuGerarRelatorio.setEnabled(false);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSound = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuGerarRelatorio = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 480));
        getContentPane().setLayout(null);

        lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speaker_on.png"))); // NOI18N
        lblSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSoundMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSoundMousePressed(evt);
            }
        });
        getContentPane().add(lblSound);
        lblSound.setBounds(670, 0, 30, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema Plantio");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 690, 70);

        mainTabbedPane.add("Login", new PanelLogin(this.menuGerarRelatorio, mainTabbedPane));
        mainTabbedPane.add("Cadastro", new PanelCadastro(mainTabbedPane));

        getContentPane().add(mainTabbedPane);
        mainTabbedPane.setBounds(0, 70, 720, 360);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -10, 730, 480);

        jMenu1.setText("Conta");
        jMenu1.setMargin(new java.awt.Insets(0, 0, 0, 10));

        jMenuItem1.setText("Cadastrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Entrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Relatório");
        jMenu2.setMargin(new java.awt.Insets(0, 0, 0, 10));

        menuGerarRelatorio.setText("Gerar Relatório");

        jMenuItem5.setText("Defensivo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuGerarRelatorio.add(jMenuItem5);

        jMenuItem6.setText("Planta");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuGerarRelatorio.add(jMenuItem6);

        jMenuItem7.setText("Lavoura");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuGerarRelatorio.add(jMenuItem7);

        jMenu2.add(menuGerarRelatorio);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Sobre");
        jMenu4.setMargin(new java.awt.Insets(0, 0, 0, 10));
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if(this.mainTabbedPane.getSelectedIndex() == 2){
            JOptionPane.showMessageDialog(null, "Você já está logado!");
        }
        else {
            this.mainTabbedPane.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if(this.mainTabbedPane.getSelectedIndex() == 2){
            JOptionPane.showMessageDialog(null, "Você já está logado!");
        }
        else {
            this.mainTabbedPane.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(this.mainTabbedPane.getSelectedIndex() == 2){
            this.dispose();
            Home main = new Home();
            main.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Você não está conectado!");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void lblSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSoundMouseClicked
        
    }//GEN-LAST:event_lblSoundMouseClicked

    private void lblSoundMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSoundMousePressed
       String iconfilename = lblSound.getIcon().toString();
        String filename = iconfilename.substring(iconfilename.lastIndexOf("/") + 1);
        if(filename.equals("speaker_on.png")){
            Main.reduzirVolume();
            lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speaker.png")));
        }
        else {            
            Main.aumentarVolume();
            lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/speaker_on.png")));
        }        
    }//GEN-LAST:event_lblSoundMousePressed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        reports.GerarRelatorio.gerarLavoura();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        reports.GerarRelatorio.gerarDefensivo();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        reports.GerarRelatorio.gerarPlanta();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {                
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JLabel lblSound;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JMenu menuGerarRelatorio;
    // End of variables declaration//GEN-END:variables
}
