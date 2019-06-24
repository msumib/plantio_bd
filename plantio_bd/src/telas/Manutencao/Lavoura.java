/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Manutencao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import telas.Listagem.ListagemLavoura;
import telas.Listagem.ListagemLavouraDetalhada;

/**
 *
 * @author itzfeltrin
 */
public class Lavoura extends javax.swing.JDialog {

    
    static void alterarLavoura(String label, double spinner) {
        dao.LavouraDao.alterar(Lavoura.codigo, label, spinner);         
    }
    
    static boolean getNovo(){
        return Lavoura.novo;
    }
    
    static void adicionarProdutividade(ArrayList<Object[]> lista){
        System.out.println("entrou nessa funcao");
        Short safra1 = Short.parseShort(Integer.toString(safra));                
        int cod_lav = Lavoura.codigo;
        
        //dao.ProdutividadeDao.inserir(qtd_sacas, safra1, Lavoura.codigo, cod_planta);      
        for(Object[] obj : lista){                        
            int qtd = (Integer) obj[0];
            short safra = (short) obj[1];                        
            int cod_planta = dao.PlantaDao.getCodigo(obj[2].toString(), obj[3].toString());  
            try {
                dao.LavouraPlantaDao.inserir(obj[4].toString(), cod_lav, cod_planta);
                dao.ProdutividadeDao.inserir(qtd, safra, cod_lav, cod_planta);
                Lavoura.listagemDetalhada.atualizarTabelaProdutividade();
                Lavoura.listagemDetalhada.atualizarTabelaPlanta();
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }                      
        }
    }

    private static int codigo;
    private ListagemLavoura listagem;
    private static ListagemLavouraDetalhada listagemDetalhada;    
    private static int cod_produtividade;
    private static int qtd_sacas;
    private static int safra;
    private static int cod_planta;
    private static boolean novo = true;
    /**
     * Creates new form Lavoura
     */
    public Lavoura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        System.out.println(Lavoura.novo);
    }
    
    public Lavoura(java.awt.Frame parent, boolean modal, ListagemLavoura listagem, int codigo, String nome, double area) throws Exception {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        this.listagem = listagem;
        this.codigo = codigo;
        this.jTabbedPane1.setSelectedIndex(0);
        this.jTabbedPane1.setEnabledAt(1, false);
        this.jTabbedPane1.setEnabledAt(2, false);
        PanelLavoura pl = (PanelLavoura) this.jTabbedPane1.getComponentAt(0);
        try {
            pl.setDisabled();
            pl.setLabel(nome);
            pl.setSpinner(area);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    public Lavoura(java.awt.Frame parent, boolean modal, ListagemLavouraDetalhada listagem, int codigo_lavoura) throws Exception {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);        
        
        this.codigo = codigo_lavoura;
        this.listagemDetalhada = listagem;
        this.novo = false;
        
        System.out.println(Lavoura.novo);
        
        this.jTabbedPane1.setSelectedIndex(1);
        this.jTabbedPane1.setEnabledAt(0, false);
        this.jTabbedPane1.setEnabledAt(2, false);
//        PanelProdutividade pp = (PanelProdutividade) this.jTabbedPane1.getComponentAt(0);
//        try {
//            pl.setDisabled();            
//        }
//        catch (Exception ex){
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//        
    }
    
    public Lavoura(java.awt.Frame parent, boolean modal, JTable tabela, int codigo_lavoura, int codigo_produtividade, int qtd_sacas, int safra, int cod_planta) throws Exception {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);        
        
        this.codigo = codigo_lavoura;
        this.cod_produtividade = codigo_produtividade;
        this.qtd_sacas = qtd_sacas;
        this.safra = safra;
        this.cod_planta = cod_planta;
        
        this.jTabbedPane1.setSelectedIndex(0);
        this.jTabbedPane1.setEnabledAt(1, false);
        this.jTabbedPane1.setEnabledAt(2, false);
        PanelLavoura pl = (PanelLavoura) this.jTabbedPane1.getComponentAt(0);
//        try {
//            pl.setDisabled();
//            pl.setLabel(nome);
//            pl.setSpinner(area);
//        }
//        catch (Exception ex){
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        setTitle("Info Lavoura");
        jTabbedPane1.add("Lavoura", new PanelLavoura(jTabbedPane1));
        jTabbedPane1.add("Produtividade da Lavoura", new telas.Manutencao.PanelProdutividade(jTabbedPane1));
        jTabbedPane1.add("Aplicação da Lavoura", new PanelAplicacao(jTabbedPane1));
        //jTabbedPane1.add("Relação Lavoura/Planta", new PanelLavouraPlanta(jTabbedPane1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
                       
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Lavoura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lavoura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lavoura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lavoura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lavoura dialog = new Lavoura(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
