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

/**
 *
 * @author Administrador
 */
public class LavouraPlantaDao {

    public static boolean inserir(String data, int codigo_lavoura, int codigo_planta) throws ParseException {

        String sql = "INSERT INTO lavoura_planta (data_do_plantio, codigo_lavoura, codigo_planta) VALUES (?, ?, ?)";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");            
            Date date = format.parse(data);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setInt(2, codigo_lavoura);
            ps.setInt(3, codigo_planta);                
            ps.executeUpdate();
            return true;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro em lavouraplantadao: " + ex.getMessage());
            return false;
        }
    }
    
    public static List<String[]> consultar(int codigo_lavoura){
        List<String[]> resultados = new ArrayList<>();
        String sql;
        sql = "SELECT lp.data_do_plantio, lp.codigo_planta, p.tipo, p.cultivar\n" +
                "	FROM lavoura_planta lp \n" +
                "	JOIN planta p ON lp.codigo_planta = p.codigo\n" +
                "	JOIN lavoura l ON lp.codigo_lavoura = l.codigo\n" +
                "	WHERE lp.codigo_lavoura = ? ORDER BY lp.data_do_plantio";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);                       
            ps.setInt(1, codigo_lavoura);                
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[4];
                int codigo = rs.getInt("codigo_planta");
                linha[0] = Integer.toString(codigo); 
                linha[1] = (rs.getDate("data_do_plantio").toString());                               
                linha[2] = rs.getString("tipo");
                linha[3] = rs.getString("cultivar");
                resultados.add(linha);
            }
            return resultados;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro em lavouraplantadao: " + ex.getMessage());
            return null;
        }
    }
    
     public static boolean deletar(int codigo_lav, int codigo_planta, String data) throws ParseException{
        String sql = "DELETE FROM lavoura_planta WHERE codigo_lavoura = ? AND codigo_planta = ? AND data_do_plantio = ?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");            
            Date date = format.parse(data);            
            ps.setInt(1, codigo_lav);
            ps.setInt(2, codigo_planta);
            ps.setDate(3, new java.sql.Date(date.getTime()));
            ps.executeUpdate();
            return true;
        }
        catch (SQLException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
