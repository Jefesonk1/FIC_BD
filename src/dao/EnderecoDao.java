package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import models.Endereco;

public class EnderecoDao {

    public static List<Cliente> read(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        stmt = con.prepareStatement("SELECT * FROM cliente WHERE primeironome = ?");

        stmt.setString(1, key);
        rs = stmt.executeQuery();

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

        return clientes;
    }
    
    
     public static Endereco readEndereco(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Endereco e = new Endereco();

        stmt = con.prepareStatement("SELECT * FROM endereco WHERE id = ?");

        stmt.setString(1, key);
        rs = stmt.executeQuery();

        while (rs.next()) {

            e.setId(rs.getInt("id"));
            e.setLogradouro(rs.getString("logradouro"));
            e.setComplemento(rs.getString("complemento"));
            e.setCidade(rs.getString("cidade"));
            e.setEstado(rs.getString("estado"));
            e.setPais(rs.getString("pais"));
            e.setCodigopostal(rs.getString("codigopostal"));
        }

        return e;
    }

    public static long create(Endereco e) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String generatedColumns[] = { "ID" };
        stmt = con.prepareStatement("INSERT INTO endereco (id, logradouro, complemento, cidade, estado, pais, codigopostal) VALUES ((SELECT max(id)+1 FROM endereco) ,?,?,?,?,?,?)", generatedColumns);
        stmt.setString(1, e.getLogradouro());
        stmt.setString(2, e.getComplemento());
        stmt.setString(3, e.getCidade());
        stmt.setString(4, e.getEstado());
        stmt.setString(5, e.getPais());
        stmt.setString(6, e.getCodigopostal());
        stmt.executeQuery();

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                  long id = generatedKeys.getLong(1);
                    System.out.println(id);
                    stmt.close();
                     return id;
            } else {
                stmt.close();
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

        
       

//            stmt = con.prepareStatement("SELECT MAX(codigo) FROM cliente;");
//            rs = stmt.executeQuery();
    }

    public static void delete(int idCliente) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;

        stmt = con.prepareStatement("DELETE FROM cliente WHERE codigo = ?");
        stmt.setInt(1, idCliente);
        stmt.executeUpdate();
        DatabaseConnection.closeConnection(con, stmt);
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
