package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.ClienteEndereco;

/**
 *
 * @author Jefeson
 */
public class ClienteEnderecoDao {
        public static void create(ClienteEndereco ce) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = con.prepareStatement("INSERT INTO clienteendereco (codigocliente, idendereco, tipoendereco) VALUES (?,?,?)");
        stmt.setLong(1, ce.getCodigoCliente());
        stmt.setLong(2, ce.getIdEndereco());
        stmt.setString(3, ce.getTipoEndereco());
        rs = stmt.executeQuery();
        stmt.close();

}
        }
