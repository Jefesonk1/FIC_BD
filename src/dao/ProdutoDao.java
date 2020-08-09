package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Produto;

public class ProdutoDao {

    public static List<Produto> buscar(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> clientes = new ArrayList<>();

        key = key.toUpperCase();
        stmt = con.prepareStatement("SELECT p.codigo, p.nome, p.preco, p.cor, c.nome as categoria, p.tamanho, p.peso FROM produto p left join categoria c on c.codigo = p.codigocategoria WHERE UPPER(p.nome) LIKE ?");

        stmt.setString(1, '%' + key + '%');
        rs = stmt.executeQuery();

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
        }

        DatabaseConnection.closeConnection(con, stmt, rs);
        return clientes;
    }

}
