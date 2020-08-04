package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Transportadora;

public class TransportadoraDao {

    public static List<Transportadora> read(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Transportadora> transportadoras = new ArrayList<>();
        try {
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
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseConnection.closeConnection(con, stmt, rs);
        }
        return transportadoras;
    }
}
