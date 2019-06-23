/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas.Manutencao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author itzfeltrin
 */
public class PanelProdutividade extends javax.swing.JPanel {

    private ArrayList<Object[]> lista = new ArrayList<>();
    private javax.swing.JTabbedPane mainTabbedPane;
    
    /**
     * Creates new form PanelAplicacao
     */
    public PanelProdutividade(javax.swing.JTabbedPane mainTabbedPane) {
        initComponents();
        this.mainTabbedPane = mainTabbedPane;
        comboboxCultivar.removeAllItems();
        comboboxCultivar.setEnabled(false);
        
        LocalDate ld = LocalDate.now();
        Short ano = Short.parseShort(Integer.toString(ld.getYear()));
        //spinnerAno.setModel(new javax.swing.SpinnerNumberModel(ano, 1900, ano, 1));
        spinnerAno.setModel(new javax.swing.SpinnerNumberModel(Integer.parseInt(Short.toString(ano)), 1900, Integer.parseInt(Short.toString(ano)), 1));
        
        comboboxPlanta.removeAllItems();
        comboboxPlanta.addItem("-");
        
        List<String> resultados = dao.PlantaDao.consultarDisintct();
        for (String linha : resultados) {
            comboboxPlanta.addItem(linha);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAvancar = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboboxCultivar = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboboxPlanta = new javax.swing.JComboBox<>();
        spinnerQtd = new javax.swing.JSpinner();
        spinnerAno = new javax.swing.JSpinner();
        btnOutro = new javax.swing.JButton();
        lblData = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        btnAvancar.setText("Avançar");
        btnAvancar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        jButton7.setText("Cancelar");
        jButton7.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Consultar");
        jButton8.setPreferredSize(new java.awt.Dimension(100, 40));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Quantidade em sacas:");

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Produtividade");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Planta:");

        comboboxCultivar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxCultivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxCultivarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Safra:");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Cultivar:");

        comboboxPlanta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxPlantaActionPerformed(evt);
            }
        });

        spinnerQtd.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        btnOutro.setText("Outro");
        btnOutro.setPreferredSize(new java.awt.Dimension(100, 40));
        btnOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutroActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Data de Plantio (dd/MM/yyyy):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboboxPlanta, 0, 157, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboboxCultivar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spinnerQtd)
                            .addComponent(spinnerAno)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOutro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel18)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spinnerQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(spinnerAno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboboxCultivar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(comboboxPlanta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAvancar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOutro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboboxCultivar, comboboxPlanta, jLabel10, jLabel7, jLabel8, jLabel9, spinnerQtd});

    }// </editor-fold>//GEN-END:initComponents

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        try {
            Integer qtd = getQtd();
            Short ano = Short.parseShort(Integer.toString(getSafra()));
            String planta = getPlanta();
            String cultivar = getCultivar();
            LocalDate ld = getDataProd();
            Object[] array = {qtd, ano, planta, cultivar, ld};
            this.lista.add(array);

            this.mainTabbedPane.setSelectedIndex(this.mainTabbedPane.getSelectedIndex() + 1);
        }
        catch (Exception ex){
            Object[] options = {"Não", "Sim"};
            int opcao = JOptionPane.showOptionDialog(null, "Deseja continuar sem adicionar Produtividade?", "Mensagem", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if(opcao == 1){
                this.mainTabbedPane.setSelectedIndex(this.mainTabbedPane.getSelectedIndex() + 1);
            }            
        }    
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.getTopLevelAncestor().setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        telas.Listagem.ListagemLavoura lav = new telas.Listagem.ListagemLavoura(null, true);
        lav.setVisible(true);
        lav.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void comboboxCultivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxCultivarActionPerformed
        
    }//GEN-LAST:event_comboboxCultivarActionPerformed

    private void comboboxPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxPlantaActionPerformed
        comboboxCultivar.removeAllItems();
        comboboxCultivar.addItem("-");
        comboboxCultivar.setEnabled(true);
        if(comboboxPlanta.getSelectedIndex() > 0){
            List<String> resultados = dao.PlantaDao.consultarCultivar(comboboxPlanta.getSelectedItem().toString());
            for (String linha : resultados) {
                comboboxCultivar.addItem(linha);
            }
        }
        else {
            comboboxCultivar.removeAllItems();
            comboboxCultivar.addItem("-");
            comboboxCultivar.setEnabled(false);
        }
    }//GEN-LAST:event_comboboxPlantaActionPerformed

    private void btnOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutroActionPerformed
        try {
            Integer qtd = getQtd();
            Short ano = Short.parseShort(Integer.toString(getSafra()));
            String planta = getPlanta();
            String cultivar = getCultivar();
            LocalDate ld = getDataProd();
            Object[] array = {qtd, ano, planta, cultivar, ld};
            this.lista.add(array);
            
            clearScreen();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    }//GEN-LAST:event_btnOutroActionPerformed

    public Integer getQtd() throws Exception{
        if(Integer.parseInt(spinnerQtd.getValue().toString()) > 0){            
            return Integer.parseInt(spinnerQtd.getValue().toString());
        }
        else {            
            throw new Exception("Quantidade deve ser maior que 0!");
        }
    }

    public Integer getSafra() throws Exception{
        if(Integer.parseInt(spinnerAno.getValue().toString()) > 0){            
            return Integer.parseInt(spinnerAno.getValue().toString());
        }
        else {
            throw new Exception("Ano inválido.");
        }
    }
    
    public String getPlanta() throws Exception{
        if(comboboxPlanta.getSelectedIndex() > 0){
            return comboboxPlanta.getSelectedItem().toString();
        }
        else {
            throw new Exception("Planta inválida.");
        }
    }
    
    public String getCultivar() throws Exception{
        if(comboboxCultivar.getSelectedIndex() > 0){
            return comboboxCultivar.getSelectedItem().toString();
        }
        else {
            throw new Exception("Cultivar inválido.");
        }
    }
    
    public LocalDate getDataProd() throws Exception {
        if (lblData.getText().length() > 0) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ld = LocalDate.parse(lblData.getText(), df);
            return ld;
        } else {
            throw new Exception("Data inválida");
        }
    }
    
    public ArrayList<Object[]> getLista(){
        return this.lista;
    }
    
    public void clearScreen(){
        LocalDate ld = LocalDate.now();
        int ano = ld.getYear();
        spinnerAno.setValue(ano);
        spinnerQtd.setValue(1);
        comboboxCultivar.setSelectedIndex(0);
        comboboxPlanta.setSelectedIndex(0);
    }
       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnOutro;
    private javax.swing.JComboBox<String> comboboxCultivar;
    private javax.swing.JComboBox<String> comboboxPlanta;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lblData;
    private javax.swing.JSpinner spinnerAno;
    private javax.swing.JSpinner spinnerQtd;
    // End of variables declaration//GEN-END:variables
}

    
