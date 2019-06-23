/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class LavouraPlantaDao {

    public static boolean inserir(String data, int codigo_lavoura, int codigo_planta) throws ParseException {

        String sql = "INSERT INTO lavoura_planta (data_do_plantio, codigo_lavoura, codigo_planta) VALUES (?, ?, ?)";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);            
            System.out.println("chegou até aqui na data do lavouraplanta");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");            
            Date date = format.parse(data);
            ps.setDate(1, new java.sql.Date(date.getTime()));
            ps.setInt(2, codigo_lavoura);
            ps.setInt(3, codigo_planta);                
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
}