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
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class AplicacaoDao {

    public static boolean inserir(String data, int codigo_lavoura) throws ParseException {

        String sql = "INSERT INTO aplicacao (data_aplicacao, codigo_lavoura) VALUES (?, ?)";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);            
            System.out.println("chegou até aqui na data do aplicacaoDao");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");            
            Date date = format.parse(data);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setInt(2, codigo_lavoura);                         
            ps.executeUpdate();
            System.out.println("fez tudo isso aqui!!!");
            return true;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao deu piazada deu erro aqui");
            System.out.println("Erro em lavouraplantadao: " + ex.getMessage());
            return false;
        }
    }     

    public static int getCodigo(String data, int codigo_lavoura) throws ParseException {

        String sql = "SELECT codigo FROM aplicacao WHERE data_aplicacao = ? AND codigo_lavoura = ?";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);            
            System.out.println("chegou até aqui na data do aplicacaoDao");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");            
            Date date = format.parse(data);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setInt(2, codigo_lavoura);                         
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
}