/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.sql.Connection;
import net.sf.jasperreports.engine.JRException;
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
}
