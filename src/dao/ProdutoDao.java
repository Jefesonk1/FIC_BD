package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Produto;

public class ProdutoDao {

    public static List<Produto> read(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> clientes = new ArrayList<>();
        try {
            
            Statement stmtt = con.createStatement();  
            ResultSet rss = stmtt.executeQuery("ALTER SESSION SET NLS_COMP=LINGUISTIC");
            rss = stmtt.executeQuery("ALTER SESSION SET NLS_SORT=BINARY_CI");
            
            stmt = con.prepareStatement("SELECT codigo,nome FROM produto WHERE nome LIKE ?");
            // String query = ("SELECT * FROM cliente WHERE primeironome = '?'");

            System.out.println(key);
            stmt.setString(1, '%'+key+'%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto a = new Produto();

                a.setCodigo(rs.getString("codigo"));
                a.setNome(rs.getString("nome"));
                clientes.add(a);
                //System.out.println(a.getPrimeiroNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseConnection.closeConnection(con, stmt, rs);
        }
        return clientes;
    }

}
