/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class UserDao {

    public static boolean inserir(String nome, String usuario, String senha) {
        String sql = "INSERT INTO usuario (nome, usuario, senha) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, usuario);
            ps.setString(3, senha);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static boolean autentica(String usuario, String senha) {
        String sql = "SELECT * FROM usuario WHERE usuario = ? and senha = ?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Login OK!");
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "Credenciais não conferem!");
                return false;
            }            
        }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }        
    }


    public static void main(String[] args) {        
    }
}
