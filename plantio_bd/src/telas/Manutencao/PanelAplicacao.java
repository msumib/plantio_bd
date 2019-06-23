/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Manutencao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author itzfeltrin
 */
public class PanelAplicacao extends javax.swing.JPanel {

    private javax.swing.JTabbedPane mainTabbedPane;
    private ArrayList<Object> lista = new ArrayList<>();

    /**
     * Creates new form PanelAplicacao
     */
    public PanelAplicacao(javax.swing.JTabbedPane mainTabbedPane) {
        initComponents();
        this.mainTabbedPane = mainTabbedPane;

        comboboxNome.removeAllItems();
        comboboxNome.setEnabled(false);

        comboboxClasse.removeAllItems();
        comboboxClasse.addItem("-");

        List<String> resultados = dao.DefensivoDao.consultarDisintct();
        for (String linha : resultados) {
            comboboxClasse.addItem(linha);
        }

//        comboboxLavoura.removeAllItems();
//        comboboxLavoura.addItem("-");
//
//        List<String> resultadosLav = dao.LavouraDao.consultarNome();
//        for (String linha : resultadosLav) {
//            comboboxLavoura.addItem(linha);
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

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblData = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        comboboxClasse = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnAvancar = new javax.swing.JButton();
        btnOutro = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        comboboxNome = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        spinnerDose = new javax.swing.JSpinner();

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Data:");

        jButton4.setText("Remover");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Defensivo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Dose (mL): ");

        jButton2.setText("Cancelar");

        jButton3.setText("Consultar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Lavoura");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Código:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lavoura 1", "Lavoura 2", "Lavoura 3" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Aplicação");

        setMaximumSize(new java.awt.Dimension(400, 215));
        setMinimumSize(new java.awt.Dimension(400, 215));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Data (dd/MM/yyyy):");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Defensivo");

        comboboxClasse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxClasseActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Dose (mL): ");

        btnAvancar.setText("Adicionar");
        btnAvancar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        btnOutro.setText("Outro");
        btnOutro.setPreferredSize(new java.awt.Dimension(100, 40));
        btnOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutroActionPerformed(evt);
            }
        });

        jButton8.setText("Consultar");
        jButton8.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Aplicação");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Classe:");

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setText("Nome:");

        comboboxNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setText("Cancelar");
        jButton9.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        spinnerDose.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerDose, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboboxNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboboxClasse, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnOutro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel18)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboboxClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboboxNome, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(spinnerDose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAvancar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOutro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboboxClasse, comboboxNome, jLabel10, jLabel7, jLabel8, jLabel9, lblData, spinnerDose});

    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void comboboxClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxClasseActionPerformed
        comboboxNome.removeAllItems();
        comboboxNome.addItem("-");
        comboboxNome.setEnabled(true);
        if (comboboxClasse.getSelectedIndex() > 0) {
            List<String> resultados = dao.DefensivoDao.consultarNome(comboboxClasse.getSelectedItem().toString());
            for (String linha : resultados) {
                comboboxNome.addItem(linha);
            }
        } else {
            comboboxNome.removeAllItems();
            comboboxNome.addItem("-");
            comboboxNome.setEnabled(false);
        }
    }//GEN-LAST:event_comboboxClasseActionPerformed

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        try {
            LocalDate data = getData();
            String classe = getClasse();
            String nome = getNome();
            //String lavoura = getLavoura();
            Double dose = getDose();
            Object[] array = {data, classe, nome, dose};
            this.lista.add(array);            
            
            Object[] options = {"Não", "Sim"};
            int opcao = JOptionPane.showOptionDialog(null, "Adicionar Lavoura?", "Mensagem", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(opcao == 1){
                PanelLavoura pl = (PanelLavoura) this.mainTabbedPane.getComponentAt(0);
                PanelProdutividade pd = (PanelProdutividade) this.mainTabbedPane.getComponent(1);
                try {                    
                    String nomeLavoura = pl.getLabel();
                    Double extensaoLavoura = pl.getSpinner();  
                    dao.LavouraDao.inserir(nomeLavoura, extensaoLavoura);
                    JOptionPane.showMessageDialog(null, "Lavoura adicionada!");
                    this.getTopLevelAncestor().setVisible(false);
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Conteúdo faltando!");
                    this.mainTabbedPane.setSelectedIndex(0);
                }
                try {                    
                    ArrayList<Object[]> lista = pd.getLista();
                    int cod_lav = dao.LavouraDao.getCodigo(pl.getLabel(), pl.getSpinner());    
                    for(Object[] obj : lista){                        
                        int qtd = (Integer) obj[0];
                        short safra = (short) obj[1];                        
                        int cod_planta = dao.PlantaDao.getCodigo(obj[2].toString(), obj[3].toString());  
                        try {
                            dao.LavouraPlantaDao.inserir(pd.getDataProd().toString(), cod_lav, cod_planta);
                            dao.ProdutividadeDao.inserir(qtd, safra, cod_lav, cod_planta);                                                         
                            this.getTopLevelAncestor().setVisible(false);
                        }
                        catch (Exception ex){
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }                        
                    }
                }
                catch (NullPointerException ex){
                    System.out.println("Deu erro nullpointer: " + ex.getMessage());
                }
            }
        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Object[] options = {"Não", "Sim"};
            int opcao = JOptionPane.showOptionDialog(null, "Deseja adicionar a lavoura sem nenhuma Aplicação?", "Mensagem", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(opcao == 1){
                PanelLavoura pl = (PanelLavoura) this.mainTabbedPane.getComponentAt(0);
                PanelProdutividade pd = (PanelProdutividade) this.mainTabbedPane.getComponent(1);
                try {                    
                    String nomeLavoura = pl.getLabel();
                    Double extensaoLavoura = pl.getSpinner();  
                    try {
                        dao.LavouraDao.inserir(nomeLavoura, extensaoLavoura);
                        JOptionPane.showMessageDialog(null, "Lavoura adicionada!");
                        this.getTopLevelAncestor().setVisible(false);
                        System.out.println("adicionou a lavoura");
                    }
                    catch(Exception ex2){
                        JOptionPane.showMessageDialog(null, ex2.getMessage());
                        System.out.println("deu erro aqui");
                    }
                    try {                    
                        System.out.println("entrou aqui");
                        ArrayList<Object[]> lista = pd.getLista();
                        int cod_lav = dao.LavouraDao.getCodigo(pl.getLabel(), pl.getSpinner());    
                        for(Object[] obj : lista){                        
                            int qtd = (Integer) obj[0];
                            short safra = (short) obj[1];
                            System.out.println("chegou ate aqui primo");
                            int cod_planta = dao.PlantaDao.getCodigo(obj[2].toString(), obj[3].toString());  
                            try {
                                System.out.println("aqui foi");
                                System.out.println(pd.getDataProd().toString());
                                
                                dao.ProdutividadeDao.inserir(qtd, safra, cod_lav, cod_planta);                                                         
                                System.out.println("produtividade foi");
                                dao.LavouraPlantaDao.inserir(pd.getDataProd().toString(), cod_lav, cod_planta);
                                this.getTopLevelAncestor().setVisible(false);
                            }
                            catch (Exception ex2){
                                System.out.println("aqui nao foi");
                                JOptionPane.showMessageDialog(null, ex2.getMessage());
                            }                        
                        }
                    }
                    catch (Exception ex3){
                        System.out.println("Deu erro nullpointer: " + ex3.getMessage());
                    }
                }
                catch (Exception ex3){
                    JOptionPane.showMessageDialog(null, "Conteúdo faltando!");
                    this.mainTabbedPane.setSelectedIndex(0);
                }
                
            }
            else {
                JOptionPane.showConfirmDialog(null, "Lavoura não foi adicionada.");
            }
        }

    }//GEN-LAST:event_btnAvancarActionPerformed
    
    private void btnOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutroActionPerformed
        try {
            LocalDate data = getData();
            String classe = getClasse();
            String nome = getNome();
            //String lavoura = getLavoura();
            Double dose = getDose();
            Object[] array = {data, classe, nome, dose};
            this.lista.add(array);
            
            clearScreen();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnOutroActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        telas.Listagem.ListagemLavoura lav = new telas.Listagem.ListagemLavoura(null, true);
        lav.setVisible(true);
        lav.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.getTopLevelAncestor().setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    public LocalDate getData() throws Exception {
        if (lblData.getText().length() > 0) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ld = LocalDate.parse(lblData.getText(), df);
            return ld;
        } else {
            throw new Exception("Aplicacao - Data inválida");
        }
    }

    public String getClasse() throws Exception {
        if (comboboxClasse.getSelectedIndex() > 0) {
            return comboboxClasse.getSelectedItem().toString();
        } else {
            throw new Exception("Classe inválida.");
        }
    }

    public String getNome() throws Exception {
        if (comboboxNome.getSelectedIndex() > 0) {
            return comboboxClasse.getSelectedItem().toString();
        } else {
            throw new Exception("Defensivo inválido.");
        }
    }

//    public String getLavoura() throws Exception {
//        if (comboboxLavoura.getSelectedIndex() > 0) {
//            return comboboxLavoura.getSelectedItem().toString();
//        } else {
//            throw new Exception("Lavoura inválida.");
//        }
//    }

    public Double getDose() throws Exception {
        if (Double.parseDouble(spinnerDose.getValue().toString()) > 0) {
            return Double.parseDouble(spinnerDose.getValue().toString());
        } else {
            throw new Exception("Dose inválida.");
        }
    }

    public void clearScreen() {
        lblData.setText("");
        comboboxClasse.setSelectedIndex(0);
        comboboxNome.setSelectedIndex(0);
        //comboboxLavoura.setSelectedIndex(0);
        spinnerDose.setValue(0);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnOutro;
    private javax.swing.JComboBox<String> comboboxClasse;
    private javax.swing.JComboBox<String> comboboxNome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField lblData;
    private javax.swing.JSpinner spinnerDose;
    // End of variables declaration//GEN-END:variables
}
