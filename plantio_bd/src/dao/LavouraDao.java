package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author umib
 */
public class LavouraDao 
{
    public static boolean inserir(String nome, Double extensao_ha) throws Exception {
        if(autentica(nome, extensao_ha)){
            String sql = "INSERT INTO lavoura (nome, extensao_ha) VALUES (?, ?)";
            try {
                PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, nome);
                ps.setDouble(2, extensao_ha);
                ps.executeUpdate();
                return true;
            }
            catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        else {
            throw new Exception("Essa lavoura já existe!");            
        }
    }
    
    public static boolean autentica(String nome, Double extensao_ha) {
        String sql = "SELECT * FROM lavoura WHERE nome = ? and extensao_ha = ?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setDouble(2, extensao_ha);
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
    
    public static List<String> consultarNome() {
        List<String> resultados = new ArrayList<>();
        String sql = "SELECT nome FROM lavoura";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String linha = rs.getString("nome");
                resultados.add(linha);
            }
            return resultados;
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static List<String[]> consultar() {
        List<String[]> resultados = new ArrayList<>();
        String sql = "SELECT codigo, nome, extensao_ha FROM lavoura ORDER BY codigo";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[3];
                linha[0] = rs.getString("codigo");
                linha[1] = rs.getString("nome");
                linha[2] = rs.getString("extensao_ha");
                resultados.add(linha);
            }
            return resultados;
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<String[]> consultar(String nome, Double extensao_ha) {
        List<String[]> resultados = new ArrayList<>();
        String sql = "SELECT codigo, nome, extensao_ha FROM lavoura WHERE nome = ? AND defensivo_ha = ?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setDouble(2, extensao_ha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[3];
                linha[0] = rs.getString("codigo");
                linha[1] = rs.getString("nome");
                linha[2] = rs.getString("extensao_ha");
                resultados.add(linha);
            }
            return resultados;
        }
        catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PlantaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static int getCodigo(String nome, Double area){
        String sql = "SELECT codigo FROM lavoura WHERE nome = ? AND extensao_ha = ?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setDouble(2, area);
            ResultSet rs = ps.executeQuery();
            int codigo = 0;
            while(rs.next()){
                codigo = rs.getInt("codigo");
            }
            return codigo;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("teu rs tá errado fi");
            return 0;            
        }
    }
        
    public static boolean alterar(int codigo, String nome, Double extensao_ha) {
        if(autentica(nome, extensao_ha)){
            String sql = "UPDATE lavoura SET nome = ?, extensao_ha = ? WHERE codigo = ?";
            try {
                PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, nome);
                ps.setDouble(2, extensao_ha);
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
        String sql = "DELETE FROM lavoura WHERE codigo = ?";
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
