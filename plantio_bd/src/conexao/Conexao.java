/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author edimar
 */
public class Conexao {

    private static Connection conn;
    private final static String driver = "org.postgresql.Driver";
    private final static String ip = "localhost:5432/";
    public static String dataBase = "plantio_bd";
    public static String user = "postgres";
    public static String password = "senha aqui";

    public Conexao(Connection conn) {
        this.conn = conn;
    }

    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        if (conn != null) {
            return conn;
        }
        
        try {
            Class.forName(driver);
        }
        catch (ClassNotFoundException c){
            JOptionPane.showMessageDialog(null, c);
        }

        try {            
            conn = java.sql.DriverManager.getConnection("jdbc:postgresql://" + ip + dataBase, user, password);            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            getConexao();
            System.out.println("Feito!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
