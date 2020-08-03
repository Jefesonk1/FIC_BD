package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Produto;

public class ProdutoDao {

    public static List<Produto> buscar(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> clientes = new ArrayList<>();
        try {

//            Statement stmtt = con.createStatement();  
//            ResultSet rss = stmtt.executeQuery("ALTER SESSION SET NLS_COMP=LINGUISTIC");
//            rss = stmtt.executeQuery("ALTER SESSION SET NLS_SORT=BINARY_CI");
            key = key.toUpperCase();
            stmt = con.prepareStatement("SELECT p.codigo, p.nome, p.preco, p.cor, c.nome as categoria, p.tamanho, p.peso FROM produto p left join categoria c on c.codigo = p.codigocategoria WHERE UPPER(p.nome) LIKE ?");
            // String query = ("SELECT * FROM cliente WHERE primeironome = '?'");

            System.out.println(key);
            stmt.setString(1, '%' + key + '%');
            rs = stmt.executeQuery();

//            ResultSetMetaData rsMeta = rs.getMetaData();
//            int columnCount = rsMeta.getColumnCount();
//            for (int i = 1; i < columnCount + 1; i++) {
//                // and print the column name, the type and the type name
//                System.out.println(rsMeta.getColumnName(i)
//                        + " ("
//                        + rsMeta.getColumnType(i)
//                        + ", "
//                        + rsMeta.getColumnTypeName(i)
//                        + ")");
//            }

            while (rs.next()) {
                Produto a = new Produto();
                //System.out.println(rs.getString());
                a.setCodigo(rs.getString("codigo"));
                a.setNome(rs.getString("nome"));
                a.setPreco(rs.getFloat("preco"));
                a.setCor(rs.getString("cor"));
                a.setCategoria(rs.getString("categoria"));
                a.setTamanho(rs.getString("tamanho"));
                a.setPeso(rs.getFloat("peso"));

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
