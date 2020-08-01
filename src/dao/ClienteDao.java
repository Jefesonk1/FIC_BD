package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;

public class ClienteDao {

    public static List<Cliente> read(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE primeironome = ?");
            // String query = ("SELECT * FROM cliente WHERE primeironome = '?'");

            System.out.println(key);
            stmt.setString(1, key);
            rs = stmt.executeQuery();
//            stmt = con.prepareStatement(query);
//            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Cliente a = new Cliente();

                a.setId(rs.getInt("codigo"));
                a.setPrimeiroNome(rs.getString("primeironome"));
                a.setNomeDoMeio(rs.getString("nomedomeio"));
                a.setSobrenome(rs.getString("sobrenome"));
                a.setTratamento(rs.getString("tratamento"));
                a.setSufixo(rs.getString("sufixo"));
                a.setSenha(rs.getString("senha"));
                clientes.add(a);
                System.out.println(a.getPrimeiroNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseConnection.closeConnection(con, stmt, rs);
        }
        return clientes;
    }

    public static Cliente read(int key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Cliente cliente = new Cliente();

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE codigo = ?");
            stmt.setInt(1, key);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cliente.setId(rs.getInt("codigo"));
                cliente.setPrimeiroNome(rs.getString("primeironome"));
                cliente.setNomeDoMeio(rs.getString("nomedomeio"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setTratamento(rs.getString("tratamento"));
                cliente.setSufixo(rs.getString("sufixo"));
                cliente.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseConnection.closeConnection(con, stmt, rs);
        }
        return cliente;
    }

    public static void create(Cliente p) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (codigo, primeironome, nomedomeio, sobrenome, tratamento, sufixo, senha) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getPrimeiroNome());
            stmt.setString(3, p.getNomeDoMeio());
            stmt.setString(4, p.getSobrenome());
            stmt.setString(5, p.getTratamento());
            stmt.setString(6, p.getSufixo());
            stmt.setString(7, p.getSenha());
            stmt.executeUpdate();

            stmt.close();

//            stmt = con.prepareStatement("SELECT MAX(codigo) FROM cliente;");
//            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseConnection.closeConnection(con, stmt, rs);
        }
    }

    public static void delete(int idCliente) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseConnection.closeConnection(con, stmt);
        }
    }

//    public void update(Cliente p) {
//        Connection con;
//        con = DatabaseConnection.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        
//        try {
//            stmt = con.prepareStatement("UPDATE cliente set nome = ?, cpf = ? WHERE id = ?");
//            stmt.setString(1, p.getNome());
//            stmt.setLong(2, p.getCpf());
//            stmt.setInt(5, p.getId());
//            rs = stmt.executeQuery();        
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally{
//            Conexao.closeConnection(con, stmt, rs);
//        }
//    }
}
