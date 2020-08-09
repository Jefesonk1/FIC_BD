package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Vendedor;

public class VendedorDao {

    public static List<Vendedor> read(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Vendedor> vendedores = new ArrayList<>();
        stmt = con.prepareStatement("SELECT * FROM vendedores WHERE primeironome = ?");

        stmt.setString(1, key);
        rs = stmt.executeQuery();
        while (rs.next()) {
            Vendedor a = new Vendedor();

            a.setCodigo(rs.getInt("codigo"));
            a.setPrimeiroNome(rs.getString("primeironome"));
            a.setNomeDoMeio(rs.getString("nomedomeio"));
            a.setSobrenome(rs.getString("sobrenome"));
            a.setSenha(rs.getString("senha"));
            a.setSexo(rs.getString("sexo"));
            a.setQuota(rs.getFloat("quota"));
            a.setDtContratacao(rs.getTimestamp("dtcontratacao"));
            a.setDtNascimento(rs.getTimestamp("dtcontratacao"));
            a.setComissao(rs.getFloat("comissao"));
            a.setBonus(rs.getFloat("bonus"));

            vendedores.add(a);
        }

        DatabaseConnection.closeConnection(con, stmt, rs);

        return vendedores;
    }

    
        public static Vendedor readVendedor(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Vendedor v = new Vendedor();
        stmt = con.prepareStatement("SELECT * FROM vendedor WHERE codigo = ?");


        stmt.setString(1, key);
        rs = stmt.executeQuery();

        while (rs.next()) {
            
            v.setCodigo(rs.getInt("codigo"));
            v.setPrimeiroNome(rs.getString("primeironome"));
            v.setNomeDoMeio(rs.getString("nomedomeio"));
            v.setSobrenome(rs.getString("sobrenome"));
            v.setSenha(rs.getString("senha"));
            v.setSexo(rs.getString("sexo"));
            v.setQuota(rs.getFloat("quota"));
            v.setDtContratacao(rs.getTimestamp("dtcontratacao"));
            v.setDtNascimento(rs.getTimestamp("dtcontratacao"));
            v.setComissao(rs.getFloat("comissao"));
            v.setBonus(rs.getFloat("bonus"));
        }

        DatabaseConnection.closeConnection(con, stmt, rs);

        return v;
    }
    
    
    public static boolean logar(int codigo, String senha) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Vendedor a = new Vendedor();
        stmt = con.prepareStatement("SELECT codigo,senha FROM vendedor WHERE codigo = ? and senha = ?");
        stmt.setInt(1, codigo);
        stmt.setString(2, senha);
        rs = stmt.executeQuery();
        while (rs.next()) {
            a.setCodigo(rs.getInt("codigo"));
            a.setSenha(rs.getString("senha"));
        }
        if (a.getCodigo() == codigo && a.getSenha().equals(senha)) {
            return true;
        }

        DatabaseConnection.closeConnection(con, stmt, rs);

        return false;
    }
}
