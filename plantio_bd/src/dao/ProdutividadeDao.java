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

/**
 *
 * @author Administrador
 */
public class ProdutividadeDao {

    public static boolean inserir(int qtd, short safra, int cod_lav, int cod_pla) {
        String sql = "INSERT INTO produtividade (qtd_sacas, safra, codigo_lavoura, codigo_planta) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, qtd);
            ps.setShort(2, safra);
            ps.setInt(3, cod_lav);
            ps.setInt(4, cod_pla);
            ps.executeUpdate();
            return true;
        } 
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static List<String[]> consultar(int codigo_lavoura){
        List<String[]> resultados = new ArrayList<>();
        String sql;
        sql = "SELECT pr.codigo, pr.qtd_sacas, pr.safra, pr.codigo_planta, p.tipo, p.cultivar\n" +
        "	FROM produtividade pr JOIN planta p ON\n" +
        "	pr.codigo_planta = p.codigo\n" +
        "	WHERE pr.codigo_lavoura = ?" + 
        "       ORDER BY pr.codigo";
        try {            
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);                       
            ps.setInt(1, codigo_lavoura);                
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[4];
                int codigo = rs.getInt("codigo");
                int codigo_pla = rs.getInt("codigo_planta");
                int qtd_sacas = rs.getInt("qtd_sacas");
                Short safra = rs.getShort("safra");
                linha[0] = Integer.toString(codigo);
                linha[1] = Integer.toString(qtd_sacas);
                linha[2] = Short.toString(safra);
                linha[3] = Integer.toString(codigo_pla);
                //linha[4] = rs.getString("tipo");
                //linha[5] = rs.getString("cultivar");
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
    
    public static boolean alterar(int qtd, Short safra, int cod_prod, int cod_pla) {
        String sql = "UPDATE produtividade SET qtd_sacas = ?, safra = ?, codigo_planta = ? WHERE codigo = ?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, qtd);
            ps.setShort(2, safra);
            ps.setInt(3, cod_pla);
            ps.setInt(4, cod_prod);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }        
    }
    
    public static boolean deletar(int codigo){
        String sql = "DELETE FROM  produtividade WHERE codigo = ?";
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
}