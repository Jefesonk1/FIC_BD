package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Cliente;
import models.DetalhesPedido;
import models.Pedido;
import models.Produto;

/**
 *
 * @author Jefeson
 */
public class DetalhesPedidoDao {

    public static void create(DetalhesPedido dp) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = con.prepareStatement("INSERT INTO detalhespedido (codigopedido, codigoproduto, quantidade, precounitario, desconto) VALUES (?,?,?,?,?)");
        stmt.setInt(1, dp.getCodigoPedido());
        stmt.setString(2, dp.getCodigoProduto());
        stmt.setInt(3, dp.getQuantidade());
        stmt.setFloat(4, dp.getPrecoUnitario());
        stmt.setFloat(5, dp.getDesconto());

        rs = stmt.executeQuery();

        stmt.close();

    }
}    
