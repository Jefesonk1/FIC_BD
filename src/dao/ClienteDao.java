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

    public static void create(Cliente p) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

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


