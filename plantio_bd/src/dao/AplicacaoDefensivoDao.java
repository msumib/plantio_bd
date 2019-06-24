/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author itzfeltrin
 */
public class AplicacaoDefensivoDao {

    
    public static boolean inserir(Double dose, int codigo_aplicacao, int codigo_defensivo) throws ParseException {

        String sql = "INSERT INTO aplicacao_defensivo (dose, codigo_aplicacao, codigo_defensivo) VALUES (?, ?, ?)";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);            
            System.out.println("chegou até aqui na data do aplicacaoDao");            
            ps.setDouble(1, dose);
            ps.setInt(2, codigo_aplicacao);
            ps.setInt(3, codigo_defensivo);
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
