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
import java.util.ArrayList;
import java.util.List;

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
    
    public static List<String[]> consultar(int codigo_lavoura){
        List<String[]> resultados = new ArrayList<>();
        String sql;
        sql = "SELECT ap.data_aplicacao, ad.dose, d.nome, d.classe\n" +
        "    FROM aplicacao_defensivo ad\n" +
        "	JOIN aplicacao ap ON  ap.codigo = ad.codigo_aplicacao\n" +
        "	JOIN defensivo d ON d.codigo = ad.codigo_defensivo\n" +
        "	WHERE ap.codigo_lavoura = ?";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);                       
            ps.setInt(1, codigo_lavoura);                
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[4];
                Double dose = rs.getDouble("dose");
                linha[0] = (rs.getDate("data_aplicacao").toString());
                linha[1] = Double.toString(dose);
                linha[2] = rs.getString("nome");
                linha[3] = rs.getString("classe");
                resultados.add(linha);
            }
            return resultados;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println("nao deu piazada deu erro aqui");
            System.out.println("Erro em lavouraplantadao: " + ex.getMessage());
            return null;
        }
    }
}
