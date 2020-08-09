package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import models.Endereco;

public class ClienteDao {

    public static List<Cliente> read(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();
        
        stmt = con.prepareStatement("SELECT * FROM cliente WHERE UPPER(primeironome) like ?");

        stmt.setString(1, "%"+key.toUpperCase()+"%");
        rs = stmt.executeQuery();

        while (rs.next()) {
            Cliente a = new Cliente();

            a.setCodigo(rs.getLong("codigo"));
            a.setPrimeiroNome(rs.getString("primeironome"));
            a.setNomeDoMeio(rs.getString("nomedomeio"));
            a.setSobrenome(rs.getString("sobrenome"));
            a.setTratamento(rs.getString("tratamento"));
            a.setSufixo(rs.getString("sufixo"));
            a.setSenha(rs.getString("senha"));
            clientes.add(a);
        }

        return clientes;
    }
    
    
    public static Cliente readCliente(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Cliente a = new Cliente();

        stmt = con.prepareStatement("SELECT * FROM cliente WHERE codigo = ?");

        stmt.setString(1, key);
        rs = stmt.executeQuery();

        while (rs.next()) {
            

            a.setCodigo(rs.getLong("codigo"));
            a.setPrimeiroNome(rs.getString("primeironome"));
            a.setNomeDoMeio(rs.getString("nomedomeio"));
            a.setSobrenome(rs.getString("sobrenome"));
            a.setTratamento(rs.getString("tratamento"));
            a.setSufixo(rs.getString("sufixo"));
            a.setSenha(rs.getString("senha"));
        }

        return a;
    }
    
    
    

    public static List<Endereco> readEndereco(int key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Endereco> endereco = new ArrayList<>();

        stmt = con.prepareStatement("SELECT E.* FROM cliente c JOIN CLIENTEENDERECO ec ON c.codigo = ec.CODIGOCLIENTE JOIN ENDERECO E ON E.ID = EC.IDENDERECO WHERE codigo = ?");
        stmt.setInt(1, key);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Endereco e = new Endereco();
            e.setId(rs.getInt("id"));
            e.setLogradouro(rs.getString("logradouro"));
            e.setComplemento(rs.getString("complemento"));
            e.setCidade(rs.getString("cidade"));
            e.setEstado(rs.getString("estado"));
            e.setPais(rs.getString("pais"));
            e.setCodigopostal(rs.getString("codigopostal"));
            endereco.add(e);
        }

        DatabaseConnection.closeConnection(con, stmt, rs);
        return endereco;
    }

    public static long create(Cliente p) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String generatedColumns[] = {"CODIGO"};
        stmt = con.prepareStatement("INSERT INTO cliente (codigo, primeironome, nomedomeio, sobrenome, tratamento, sufixo, senha) VALUES ((SELECT max(codigo)+1 FROM cliente) ,?,?,?,?,?,?)", generatedColumns);
        stmt.setString(1, p.getPrimeiroNome());
        stmt.setString(2, p.getNomeDoMeio());
        stmt.setString(3, p.getSobrenome());
        stmt.setString(4, p.getTratamento());
        stmt.setString(5, p.getSufixo());
        stmt.setString(6, p.getSenha());
        stmt.executeUpdate();

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                long codigo = generatedKeys.getLong(1);
                stmt.close();
                return codigo;
            } else {
                stmt.close();
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
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

}
