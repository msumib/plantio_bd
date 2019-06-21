/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class PlantaDao {

    public static boolean inserir(String tipo, String cultivar) {
        if(autentica(tipo, cultivar)){
            String sql = "INSERT INTO planta (tipo, cultivar) VALUES (?, ?)";
            try {
                PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, tipo);
                ps.setString(2, cultivar);
                ps.executeUpdate();
                return true;
            } 
            catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        else {
            System.out.println("Essa planta já existe!");
            return false;
        }        
    }
    
    public static boolean autentica(String tipo, String cultivar) {
        String sql = "SELECT * FROM planta WHERE tipo = ? AND cultivar = ?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tipo);
            ps.setString(2, cultivar);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Já existe!");
                return false;
            }
            else {
                return true;
            }            
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }        
    }
    
    public static List<String[]> consultar() {
        List<String[]> resultados = new ArrayList<>();
        String sql = "SELECT codigo, tipo, cultivar FROM planta";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[3];
                linha[0] = rs.getString("codigo");
                linha[1] = rs.getString("tipo");
                linha[2] = rs.getString("cultivar");
                resultados.add(linha);
            }
            return resultados;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<String[]> consultar(String tipo, String cultivar) {
        List<String[]> resultados = new ArrayList<>();
        String sql = "SELECT codigo, tipo, cultivar FROM planta WHERE tipo = ? AND cultivar = ?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tipo);
            ps.setString(2, cultivar);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[3];
                linha[0] = rs.getString("codigo");
                linha[1] = rs.getString("tipo");
                linha[2] = rs.getString("cultivar");
                resultados.add(linha);
            }
            return resultados;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static boolean remove(String tipo, String cultivar){
        String sql = "REMOVE FROM planta WHERE tipo = ? and cultivar = ?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tipo);
            ps.setString(2, cultivar);
            ResultSet rs = ps.executeQuery();
            return true;
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } 
    }
    
    public static boolean alterar(int codigo, String tipo, String cultivar) {
        if(autentica(tipo, cultivar)){
            String sql = "UPDATE planta SET tipo = ?, cultivar = ? WHERE codigo = ?";
            try {
                PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, tipo);
                ps.setString(2, cultivar);
                ps.setInt(3, codigo);
                ps.executeUpdate();
                return true;
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        else {
            System.out.println("Voce nao fez nenhuma mudança.");
            return false;
        }
    }
   
    public static void main(String[] args) {        
    }
}