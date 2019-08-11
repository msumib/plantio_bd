/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author itzfeltrin
 */
public class GerarRelatorio {
    
    public static void gerarDefensivo(){
        try {
            Connection conn = conexao.Conexao.getConexao();
            String src = "jasper/defensivo.jasper";
            JasperPrint jasperPrint = null;
            try {
                jasperPrint = JasperFillManager.fillReport(src, null, conn);
            }
            catch (JRException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
            
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setVisible(true);
        }
        catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());    
        }
    }
    
    public static void gerarPlanta(){
        try {
            Connection conn = conexao.Conexao.getConexao();
            String src = "jasper/planta.jasper";
            JasperPrint jasperPrint = null;
            try {
                jasperPrint = JasperFillManager.fillReport(src, null, conn);
            }
            catch (JRException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
            
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setVisible(true);
        }
        catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());    
        }
    }
    
    public static void gerarLavoura(){
        try {
            Connection conn = conexao.Conexao.getConexao();
            String src = "jasper/lavoura.jasper";
            JasperPrint jasperPrint = null;
            try {
                jasperPrint = JasperFillManager.fillReport(src, null, conn);
            }
            catch (JRException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
            
            JasperViewer view = new JasperViewer(jasperPrint, false);
            view.setVisible(true);
        }
        catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());    
        }
    }
    
    public static void gerarLavouraEspecifica(String nome){
        PreparedStatement ps;
        try {
            Connection conn = conexao.Conexao.getConexao();
            
            String sql = "select l.nome, l.extensao_ha, lp.data_do_plantio, p.tipo, p.cultivar\n" +
                        "from lavoura l\n" +
                        "join lavoura_planta lp on lp.codigo_lavoura = l.codigo\n" +
                        "join planta p on p.codigo = lp.codigo_planta WHERE nome = \'" + nome + "\';";//Código SQL que ira retornar a consulta e que vc vai passar para o relatório
            System.out.println(sql);
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            /* implementação da interface JRDataSource para DataSource ResultSet */
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            /* HashMap de parametros utilizados no relatório. Sempre instanciados */
            Map parameters = new HashMap();
            Object codigo_lavoura = null;
            //Passa as datas como parâmetro para aparecer no relatório
            parameters.put("codigo", codigo_lavoura);//Aqui vc passa os parâmetros para um hashmap, que será enviado para o relatório;
            /* Preenche o relatório com os dados. */
            String jasperPrint = null;
            String src = "jasper/lavouraEspecifica.jasper";
            try {
                jasperPrint = JasperFillManager.fillReportToFile(src, parameters, jrRS);
            }
            catch (JRException ex){
                System.out.println("Erro: " + ex.getMessage());
            }
            
            JasperViewer view = new JasperViewer(jasperPrint, false, false);
            view.setTitle("Relatório Lavoura");
            view.setVisible(true);
        }
        catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());    
        }
    }
}
