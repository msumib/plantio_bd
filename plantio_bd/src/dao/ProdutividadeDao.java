/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}