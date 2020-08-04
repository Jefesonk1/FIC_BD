package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Pedido;

/**
 *
 * @author Jefeson
 */
public class PedidoDao {

    public static long create(Pedido p) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String generatedColumns[] = {"CODIGO"};
        stmt = con.prepareStatement("INSERT INTO pedido (codigo, dtpedido, codigocliente, contacliente, numerocartaocredito, codigoconfirmacao, codigovendedor, imposto, enderecofatura, enderecoentrega, codigotransportadora) VALUES ((SELECT max(codigo)+1 FROM pedido) ,?,?,?,?,?,?,?,?,?,?)", generatedColumns);
        stmt.setTimestamp(1, p.getDtpedido());
        stmt.setInt(2, p.getCodigoCliente());
        stmt.setString(3, p.getContaCliente());
        stmt.setInt(4, p.getNumeroCartaoCredito());
        stmt.setString(5, p.getCodigoConfirmacao());
        stmt.setInt(6, p.getCodigoVendedor());
        stmt.setFloat(7, p.getImposto());
        stmt.setInt(8, p.getEnderecoFatura());
        stmt.setInt(9, p.getEnderecoEntrega());
        stmt.setInt(10, p.getCodigoTransportadora());
        stmt.executeQuery();

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                long codigo = generatedKeys.getLong(1);
                System.out.println(codigo);
                stmt.close();
                return codigo;
            } else {
                stmt.close();
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }

    }

    public static List<Pedido> read(String key) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pedido> pedidos = new ArrayList<>();

        stmt = con.prepareStatement("SELECT * FROM pedido WHERE codigovendedor = ?");

        stmt.setString(1, key);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();

            p.setCodigo(rs.getInt("codigo"));
            p.setDtpedido(rs.getTimestamp("dtpedido"));
            p.setDtenvio(rs.getTimestamp("dtenvio"));
            p.setDtrecebimento(rs.getTimestamp("dtrecebimento"));
            p.setCodigoCliente(rs.getInt("codigocliente"));
            p.setContaCliente(rs.getString("contacliente"));
            p.setNumeroCartaoCredito(rs.getInt("numerocartaocredito"));
            p.setCodigoConfirmacao(rs.getString("codigoconfirmacao"));
            p.setCodigoVendedor(rs.getInt("codigovendedor"));
            p.setImposto(rs.getFloat("imposto"));
            p.setEnderecoFatura(rs.getInt("enderecofatura"));
            p.setEnderecoEntrega(rs.getInt("enderecoentrega"));
            p.setCodigoTransportadora(rs.getInt("codigotransportadora"));
            pedidos.add(p);
        }

        return pedidos;
    }
}
