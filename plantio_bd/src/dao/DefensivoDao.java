/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class DefensivoDao {

    public static boolean inserir(String nome, String classe) {
        if(autentica(nome, classe)){
            String sql = "INSERT INTO defensivo (nome, classe) VALUES (?, ?)";
            try {
                PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, classe);
                ps.executeUpdate();
                return true;
            }
            catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        else {
            System.out.println("Defensivo já existe!");
            return false;
        }
    }
    
    public static boolean autentica(String nome, String classe) {
        String sql = "SELECT * FROM defensivo WHERE nome = ? and classe = ?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, classe);
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
        String sql = "SELECT codigo, nome, classe FROM defensivo";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[3];
                linha[0] = rs.getString("codigo");
                linha[1] = rs.getString("nome");
                linha[2] = rs.getString("classe");
                resultados.add(linha);
            }
            return resultados;
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<String> consultarDisintct() {
        ArrayList<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT(classe) FROM defensivo";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("classe"));
            }
            return lista;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<String> consultarNome(String classe) {
        ArrayList<String> lista = new ArrayList<>();
        String sql = "SELECT nome FROM defensivo WHERE classe = ?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, classe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nome"));
            }
            return lista;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<String[]> consultar(String nome, String classe) {
        List<String[]> resultados = new ArrayList<>();
        String sql = "SELECT codigo, nome, classe FROM defensivo WHERE nome = ? AND classe = ?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, classe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[3];
                linha[0] = rs.getString("codigo");
                linha[1] = rs.getString("nome");
                linha[2] = rs.getString("classe");
                resultados.add(linha);
            }
            return resultados;
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static int getCodigo(String nome, String classe) {
        String sql = "SELECT codigo FROM defensivo WHERE nome = ? AND classe = ?";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);            
            System.out.println("chegou até aqui na data do aplicacaoDao");            
            ps.setString(1, nome);
            ps.setString(2, classe);                         
            ResultSet rs = ps.executeQuery();
            int codigo = 0;
            while(rs.next()){
                codigo = rs.getInt("codigo");
            }
            return codigo;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao deu piazada deu erro aqui");
            System.out.println("Erro em lavouraplantadao: " + ex.getMessage());
            return 0;
        }
    } 
    
    public static boolean alterar(int codigo, String nome, String classe) {
        if(autentica(nome, classe)){
            String sql = "UPDATE defensivo SET nome = ?, classe = ? WHERE codigo = ?";
            try {
                PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, classe);
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
    
    public static boolean deletar(int codigo){
        String sql = "DELETE FROM defensivo WHERE codigo = ?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
   
    public static void main(String[] args) {        
    }
}