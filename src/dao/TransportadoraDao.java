package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Transportadora;

public class TransportadoraDao {

    public static List<Transportadora> read(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Transportadora> transportadoras = new ArrayList<>();
        stmt = con.prepareStatement("SELECT * FROM transportadora");
        // String query = ("SELECT * FROM cliente WHERE primeironome = '?'");

        System.out.println(key);
        // stmt.setString(1, key);
        rs = stmt.executeQuery();
//            stmt = con.prepareStatement(query);
//            rs = stmt.executeQuery(query);
        while (rs.next()) {
            Transportadora t = new Transportadora();

            t.setCodigo(rs.getInt("codigo"));
            t.setNome(rs.getString("nome"));
            t.setTaxaBase(rs.getFloat("taxabase"));
            t.setTaxaEnvio(rs.getFloat("taxaenvio"));
            transportadoras.add(t);
        }

        DatabaseConnection.closeConnection(con, stmt, rs);

        return transportadoras;
    }

    public static Transportadora readTransportadora(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Transportadora t = new Transportadora();
        stmt = con.prepareStatement("SELECT * FROM transportadora where codigo = ?");
        // String query = ("SELECT * FROM cliente WHERE primeironome = '?'");

        System.out.println(key);
        stmt.setString(1, key);
        rs = stmt.executeQuery();
        while (rs.next()) {

            t.setCodigo(rs.getInt("codigo"));
            t.setNome(rs.getString("nome"));
            t.setTaxaBase(rs.getFloat("taxabase"));
            t.setTaxaEnvio(rs.getFloat("taxaenvio"));
        }

        DatabaseConnection.closeConnection(con, stmt, rs);

        return t;
    }
}
