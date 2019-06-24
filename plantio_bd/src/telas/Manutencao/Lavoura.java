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
        dao.LavouraDao.alterar(Lavoura.codigo_lavoura, label, spinner);         
    }
    
    static boolean getNovo(){
        return Lavoura.novo;
    }
    
    static void adicionarProdutividade(ArrayList<Object[]> lista){
        Short safra1 = Short.parseShort(Integer.toString(safra));                
        int cod_lav = Lavoura.codigo_lavoura;
        
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
    
    static void alterarProdutividade(int qtd, Short ano, int codigo_planta, String data){
        int cod_lav = Lavoura.codigo_lavoura;
        int cod_produtividade = Lavoura.cod_produtividade;            
        try {
            dao.LavouraPlantaDao.inserir(data, cod_lav, codigo_planta);
            dao.ProdutividadeDao.alterar(qtd, safra, cod_produtividade, codigo_planta);
            Lavoura.listagemDetalhada.atualizarTabelaProdutividade();
            Lavoura.listagemDetalhada.atualizarTabelaPlanta();            
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    static void adicionarAplicacao(ArrayList<Object[]> lista) throws java.text.ParseException {              
        //int cod_lav = Lavoura.codigo_lavoura;
        
        //dao.ProdutividadeDao.inserir(qtd_sacas, safra1, Lavoura.codigo, cod_planta);      
        for(Object[] obj : lista){
            try {
                String dataAplicacao = obj[0].toString();
                int codigo_lavoura = Lavoura.codigo_lavoura;              
                Double doseAplicacaoDefensivo = (Double) obj[3];
                dao.AplicacaoDao.inserir(dataAplicacao, codigo_lavoura);
                int cod_aplicacao = dao.AplicacaoDao.getCodigo(dataAplicacao, codigo_lavoura);
                int cod_defensivo = dao.DefensivoDao.getCodigo(obj[2].toString(), obj[1].toString());                
                dao.AplicacaoDefensivoDao.inserir(doseAplicacaoDefensivo, cod_aplicacao, cod_defensivo);
                Lavoura.listagemDetalhada.atualizarTabelaAplicacao();
            }
            catch (Exception ex){
                System.out.println("Erro aqui fiao: " + ex.getMessage());
            }
        }
    }
    
    static void alterarAplicacao(double dose, String data_aplicacao, String nome, String classe) throws java.text.ParseException {
        int codigo_aplicacao = Lavoura.codigo_aplicacao;
        int codigo_defensivo = Lavoura.codigo_defensivo;        
        try {
            dao.AplicacaoDao.alterar(codigo_aplicacao, data_aplicacao);
            dao.DefensivoDao.alterar(codigo_defensivo, nome, classe);
            dao.AplicacaoDefensivoDao.alterar(dose, codigo_aplicacao, codigo_defensivo);
            Lavoura.listagemDetalhada.atualizarTabelaAplicacao();
        }
        catch (Exception ex){
            System.out.println("Erro aqui fiao: " + ex.getMessage());
        }
        
    }

    private static int codigo_lavoura;
    private ListagemLavoura listagem;
    private static ListagemLavouraDetalhada listagemDetalhada;    
    private static int cod_produtividade;
    private static int qtd_sacas;
    private static short safra;
    private static int cod_planta;
    private static int codigo_aplicacao;
    private static String data_aplicacao;
    private static int codigo_defensivo;
    private static Double dose;
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
        
        
        PanelLavoura pl = (PanelLavoura) this.jTabbedPane1.getComponent(0);
        PanelProdutividade pp = (PanelProdutividade) this.jTabbedPane1.getComponent(1);
        PanelAplicacao pa = (PanelAplicacao) this.jTabbedPane1.getComponent(2);
        try {
            pl.setDisabled1();
            pp.setDisabled1();
            pa.setDisabled1();
        }
        catch (Exception ex){
            
        }
    }
    
    public Lavoura(java.awt.Frame parent, boolean modal, ListagemLavoura listagem, int codigo, String nome, double area) throws Exception {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        this.listagem = listagem;
        this.codigo_lavoura = codigo;
        this.jTabbedPane1.setSelectedIndex(0);
        this.jTabbedPane1.setEnabledAt(1, false);
        this.jTabbedPane1.setEnabledAt(2, false);
        PanelLavoura pl = (PanelLavoura) this.jTabbedPane1.getComponentAt(0);
        try {
            pl.setDisabled2();
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
        
        this.codigo_lavoura = codigo_lavoura;
        this.listagemDetalhada = listagem;
        this.novo = false;
        
        System.out.println(Lavoura.novo);
        
        this.jTabbedPane1.setSelectedIndex(1);
        this.jTabbedPane1.setEnabledAt(0, false);
        this.jTabbedPane1.setEnabledAt(2, false);

        PanelProdutividade pp = (PanelProdutividade) this.jTabbedPane1.getComponent(1);
        try {
            pp.setDisabled1();
        }
        catch (Exception ex){
            
        }
    }
    
    public Lavoura(java.awt.Frame parent, boolean modal, ListagemLavouraDetalhada listagem, int codigo_lavoura, char a) throws Exception {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);        
        
        this.codigo_lavoura = codigo_lavoura;
        this.listagemDetalhada = listagem;
        this.novo = false;
        
        System.out.println(Lavoura.novo);
        
        this.jTabbedPane1.setSelectedIndex(2);
        this.jTabbedPane1.setEnabledAt(0, false);
        this.jTabbedPane1.setEnabledAt(1, false);
        PanelAplicacao pa = (PanelAplicacao) this.jTabbedPane1.getComponent(2);
        try {            
            pa.setDisabled1();
        }
        catch (Exception ex){
            
        }
    }
    
    public Lavoura(java.awt.Frame parent, boolean modal, ListagemLavouraDetalhada listagem, int codigo_lavoura, int codigo_produtividade, int qtd_sacas, short safra, int cod_planta) throws Exception {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);        
                
        this.novo = false;
        
        this.listagemDetalhada = listagem;
        this.codigo_lavoura = codigo_lavoura;
        this.cod_produtividade = codigo_produtividade;
        this.qtd_sacas = qtd_sacas;
        this.safra = safra;
        this.cod_planta = cod_planta;
        String tipo = dao.PlantaDao.select(this.cod_planta)[0];
        String cultivar = dao.PlantaDao.select(this.cod_planta)[1];        
        this.jTabbedPane1.setSelectedIndex(1);
        this.jTabbedPane1.setEnabledAt(0, false);
        this.jTabbedPane1.setEnabledAt(2, false);
        PanelProdutividade pp = (PanelProdutividade) this.jTabbedPane1.getComponentAt(1);
        try {                        
            pp.setPlanta(tipo);
            pp.setCultivar(cultivar);            
            pp.setQtd(this.qtd_sacas);
            pp.setSafra(this.safra);
            pp.setDisabled2();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public Lavoura(java.awt.Frame parent, boolean modal, ListagemLavouraDetalhada listagem, int codigo_lavoura ,int codigo_aplicacao, int codigo_defensivo) throws Exception {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);        
                
        this.novo = false;
        
        this.listagemDetalhada = listagem;
        this.codigo_lavoura = codigo_lavoura;
        this.codigo_aplicacao = codigo_aplicacao;        
        this.codigo_defensivo = codigo_defensivo;   
        
        this.jTabbedPane1.setSelectedIndex(2);
        this.jTabbedPane1.setEnabledAt(0, false);
        this.jTabbedPane1.setEnabledAt(1, false);
    }
    
    public Lavoura(java.awt.Frame parent, boolean modal, ListagemLavouraDetalhada listagem, int codigo_lavoura ,int codigo_aplicacao, String data_aplicacao, int codigo_defensivo, Double dose) throws Exception {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);        
                
        this.novo = false;
        
        this.listagemDetalhada = listagem;
        this.codigo_lavoura = codigo_lavoura;
        this.codigo_aplicacao = codigo_aplicacao;
        this.data_aplicacao = data_aplicacao;
        this.codigo_defensivo = codigo_defensivo;
        this.dose = dose;        
       
        String nome = dao.DefensivoDao.select(this.codigo_defensivo)[0];
        String classe = dao.DefensivoDao.select(this.codigo_defensivo)[1];
        
        this.jTabbedPane1.setSelectedIndex(2);
        this.jTabbedPane1.setEnabledAt(0, false);
        this.jTabbedPane1.setEnabledAt(1, false);
        PanelAplicacao pa = (PanelAplicacao) this.jTabbedPane1.getComponentAt(2);
        try {                        
            pa.setDose(this.dose);
            pa.setNome(nome);
            pa.setClasse(classe);
            pa.setData(this.data_aplicacao);
            pa.setDisabled2();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
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
