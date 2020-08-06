package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import models.Endereco;

import models.Pedido;
import models.Produto;
import models.Transportadora;
import models.Vendedor;

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
        stmt.setLong(2, p.getCodigoCliente());
        stmt.setString(3, p.getContaCliente());
        stmt.setLong(4, p.getNumeroCartaoCredito());
        stmt.setString(5, p.getCodigoConfirmacao());
        stmt.setLong(6, p.getCodigoVendedor());
        stmt.setFloat(7, p.getImposto());
        stmt.setLong(8, p.getCodigoEnderecoFatura());
        stmt.setLong(9, p.getCodigoEnderecoEntrega());
        stmt.setLong(10, p.getCodigoTransportadora());
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

    public static void create(Pedido pe, Produto pr) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = con.prepareStatement("INSERT INTO detalhespedido (codigopedido, codigoproduto, quantidade, precounitario, desconto) VALUES (?,?,?,?,?)");
        stmt.setLong(1, pe.getCodigo());
        stmt.setString(2, pr.getCodigo());
        stmt.setLong(3, pr.getQuantidade());
        stmt.setFloat(4, pr.getPreco());
        stmt.setFloat(5, pr.getDesconto());

        rs = stmt.executeQuery();

        stmt.close();
        rs.close();

    }

    public static List<Pedido> readByCodigoVendedor(String codigoVendedor) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pedido> pedidos = new ArrayList<>();

        stmt = con.prepareStatement("SELECT c.primeironome, c.nomedomeio, c.sobrenome,p.*,v.PRIMEIRONOME AS PRIMEIRONOMEVENDEDOR,v.NOMEDOMEIO AS NOMEDOMEIOVENDEDOR,v.SOBRENOME AS SOBRENOMEVENDEDOR FROM pedido p JOIN vendedor v ON v.codigo = p.CODIGOVENDEDOR JOIN cliente c ON c.codigo = p.CODIGOCLIENTE WHERE codigovendedor = ?");

        stmt.setString(1, codigoVendedor);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();
            Cliente c = new Cliente();
            Vendedor v = new Vendedor();
            v.setPrimeiroNome(rs.getString("primeironomevendedor"));
            v.setNomeDoMeio(rs.getString("nomedomeiovendedor"));
            v.setSobrenome(rs.getString("sobrenomevendedor"));
            c.setPrimeiroNome(rs.getString("primeironome"));
            c.setNomeDoMeio(rs.getString("nomedomeio"));
            c.setSobrenome(rs.getString("sobrenome"));
            p.setCodigo(rs.getLong("codigo"));
            p.setDtpedido(rs.getTimestamp("dtpedido"));
            p.setDtenvio(rs.getTimestamp("dtenvio"));
            p.setDtrecebimento(rs.getTimestamp("dtrecebimento"));
            p.setCodigoCliente(rs.getLong("codigocliente"));
            p.setContaCliente(rs.getString("contacliente"));
            p.setNumeroCartaoCredito(rs.getLong("numerocartaocredito"));
            p.setCodigoConfirmacao(rs.getString("codigoconfirmacao"));
            p.setCodigoVendedor(rs.getLong("codigovendedor"));
            p.setImposto(rs.getFloat("imposto"));
            p.setCodigoEnderecoFatura(rs.getLong("enderecofatura"));
            p.setCodigoEnderecoEntrega(rs.getLong("enderecoentrega"));
            p.setCodigoTransportadora(rs.getLong("codigotransportadora"));
            p.setCliente(c);
            p.setVendedor(v);
            pedidos.add(p);
        }

        return pedidos;
    }

    
      public static List<Pedido> readByNomeCliente(String nomeCliente) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pedido> pedidos = new ArrayList<>();

        stmt = con.prepareStatement("SELECT * FROM pedido p join cliente c on c.codigo= p.codigocliente WHERE UPPER(primeironome) like ?");

        stmt.setString(1, '%'+nomeCliente.toUpperCase()+'%');
        rs = stmt.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();

            p.setCodigo(rs.getLong("codigo"));
            p.setDtpedido(rs.getTimestamp("dtpedido"));
            p.setDtenvio(rs.getTimestamp("dtenvio"));
            p.setDtrecebimento(rs.getTimestamp("dtrecebimento"));
            p.setCodigoCliente(rs.getLong("codigocliente"));
            p.setContaCliente(rs.getString("contacliente"));
            p.setNumeroCartaoCredito(rs.getLong("numerocartaocredito"));
            p.setCodigoConfirmacao(rs.getString("codigoconfirmacao"));
            p.setCodigoVendedor(rs.getLong("codigovendedor"));
            p.setImposto(rs.getFloat("imposto"));
            p.setCodigoEnderecoFatura(rs.getLong("enderecofatura"));
            p.setCodigoEnderecoEntrega(rs.getLong("enderecoentrega"));
            p.setCodigoTransportadora(rs.getLong("codigotransportadora"));
            pedidos.add(p);
        }

        return pedidos;
    }
    
    
    
        public static List<Pedido> readByNomeVendedor(String nomeVendedor) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pedido> pedidos = new ArrayList<>();

        stmt = con.prepareStatement("SELECT * FROM pedido p join vendedor v on v.codigo= p.codigovendedor WHERE UPPER(primeironome) like ?");

        stmt.setString(1, '%'+nomeVendedor.toUpperCase()+'%');
        rs = stmt.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();

            p.setCodigo(rs.getLong("codigo"));
            p.setDtpedido(rs.getTimestamp("dtpedido"));
            p.setDtenvio(rs.getTimestamp("dtenvio"));
            p.setDtrecebimento(rs.getTimestamp("dtrecebimento"));
            p.setCodigoCliente(rs.getLong("codigocliente"));
            p.setContaCliente(rs.getString("contacliente"));
            p.setNumeroCartaoCredito(rs.getLong("numerocartaocredito"));
            p.setCodigoConfirmacao(rs.getString("codigoconfirmacao"));
            p.setCodigoVendedor(rs.getLong("codigovendedor"));
            p.setImposto(rs.getFloat("imposto"));
            p.setCodigoEnderecoFatura(rs.getLong("enderecofatura"));
            p.setCodigoEnderecoEntrega(rs.getLong("enderecoentrega"));
            p.setCodigoTransportadora(rs.getLong("codigotransportadora"));
            pedidos.add(p);
        }

        return pedidos;
    }
    
    
    
    
    
    
    
    
    
    
    
    public static Pedido readByCodigoPedido(Long codigoPedido) throws SQLException {
        Connection con;
        con = DatabaseConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Pedido p = new Pedido();

        String query = "SELECT PE.CODIGO, PE.DTPEDIDO as dtpedido, PE.DTENVIO, PE.DTRECEBIMENTO, PE.CODIGOCLIENTE,"
                + "PE.CONTACLIENTE, PE.NUMEROCARTAOCREDITO, PE.CODIGOCONFIRMACAO, PE.CODIGOVENDEDOR, PE.IMPOSTO, PE.ENDERECOFATURA, PE.ENDERECOENTREGA, PE.CODIGOTRANSPORTADORA,"
                + "C.PRIMEIRONOME, C.NOMEDOMEIO ,C.SOBRENOME ,C.SUFIXO ,C.TRATAMENTO,"
                + "ENFATURA.LOGRADOURO AS LOGRADOUROFATURA, ENFATURA.COMPLEMENTO AS COMPLEMENTOFATURA,ENFATURA.CIDADE AS CIDADEFATURA, ENFATURA.ESTADO AS ESTADOFATURA,ENFATURA.PAIS AS PAISFATURA, ENFATURA.CODIGOPOSTAL AS CODIGOPOSTALFATURA,"
                + "E.LOGRADOURO AS LOGRADOUROENTREGA, E.COMPLEMENTO AS COMPLEMENTOENTREGA,E.CIDADE AS CIDADEENTREGA, E.ESTADO AS ESTADOENTREGA ,E.PAIS AS PAISENTREGA, E.CODIGOPOSTAL AS CODIGOPOSTALENTREGA,"
                + "T.NOME AS NOMETRANSPORTADORA, T.TAXABASE AS TAXABASETRANSPORTADORA, T.TAXAENVIO AS TAXAENVIOTRANSPORTADORA, "
                + "V.PRIMEIRONOME AS PRIMEIRONOMEVENDEDOR, V.NOMEDOMEIO AS NOMEDOMEIOVENDEDOR, V.SOBRENOME AS SOBRENOMEVENDEDOR "
                + "FROM PEDIDO PE "
                + "JOIN CLIENTE C ON PE.CODIGOCLIENTE = C.CODIGO "
                + "JOIN ENDERECO ENFATURA ON ENFATURA.ID= PE.ENDERECOFATURA "
                + "JOIN ENDERECO E ON E.ID = PE.ENDERECOENTREGA "
                + "JOIN TRANSPORTADORA T ON T.CODIGO = PE.CODIGOTRANSPORTADORA "
                + "JOIN VENDEDOR V ON V.CODIGO = PE.CODIGOVENDEDOR "
                + "WHERE PE.CODIGO = ? ";

        stmt = con.prepareStatement(query);
        stmt.setLong(1, codigoPedido);
        rs = stmt.executeQuery();

        Cliente cliente = new Cliente();
        Endereco fatura = new Endereco();
        Endereco entrega = new Endereco();
        Vendedor vendedor = new Vendedor();
        Transportadora transportadora = new Transportadora();
        List<Produto> produtos = new ArrayList<>();
        
        while (rs.next()) {
            p.setCodigo(rs.getLong("codigo"));
            p.setDtpedido(rs.getTimestamp("dtpedido"));
            p.setDtenvio(rs.getTimestamp("dtenvio"));
            p.setDtrecebimento(rs.getTimestamp("dtrecebimento"));
            p.setCodigoCliente(rs.getLong("codigocliente"));
            p.setContaCliente(rs.getString("contacliente"));
            p.setNumeroCartaoCredito(rs.getInt("numerocartaocredito"));
            p.setCodigoConfirmacao(rs.getString("codigoconfirmacao"));
            p.setCodigoVendedor(rs.getInt("codigovendedor"));
            p.setImposto(rs.getFloat("imposto"));
            p.setCodigoEnderecoFatura(rs.getLong("enderecofatura"));
            p.setCodigoEnderecoEntrega(rs.getLong("enderecoentrega"));
            p.setCodigoTransportadora(rs.getLong("codigotransportadora"));

            cliente.setCodigo(rs.getLong("codigocliente"));
            cliente.setPrimeiroNome(rs.getString("primeironome"));
            cliente.setNomeDoMeio(rs.getString("nomedomeio"));
            cliente.setSobrenome(rs.getString("sobrenome"));
            cliente.setSufixo(rs.getString("sufixo"));
            cliente.setTratamento(rs.getString("tratamento"));
            p.setCliente(cliente);

            fatura.setId(rs.getLong("enderecofatura"));
            fatura.setLogradouro(rs.getString("logradourofatura"));
            fatura.setComplemento(rs.getString("complementofatura"));
            fatura.setCidade(rs.getString("cidadefatura"));
            fatura.setEstado(rs.getString("estadofatura"));
            fatura.setPais(rs.getString("paisfatura"));
            fatura.setCodigopostal(rs.getString("codigopostalfatura"));
            p.setEnderecoFatura(fatura);

            fatura.setId(rs.getLong("enderecoentrega"));
            fatura.setLogradouro(rs.getString("logradouroentrega"));
            fatura.setComplemento(rs.getString("complementoentrega"));
            fatura.setCidade(rs.getString("cidadeentrega"));
            fatura.setEstado(rs.getString("estadoentrega"));
            fatura.setPais(rs.getString("paisentrega"));
            fatura.setCodigopostal(rs.getString("codigopostalentrega"));
            p.setEnderecoEntrega(fatura);

            transportadora.setCodigo(rs.getLong("codigotransportadora"));
            transportadora.setNome(rs.getString("nometransportadora"));
            transportadora.setTaxaBase(rs.getFloat("taxabasetransportadora"));
            transportadora.setTaxaEnvio(rs.getFloat("taxaenviotransportadora"));
            p.setTrasportadora(transportadora);

            vendedor.setCodigo(rs.getLong("codigovendedor"));
            vendedor.setPrimeiroNome(rs.getString("primeironomevendedor"));
            vendedor.setNomeDoMeio(rs.getString("nomedomeiovendedor"));
            vendedor.setSobrenome(rs.getString("sobrenomevendedor"));
            p.setVendedor(vendedor);

        }

        query = "SELECT P.NOME,P.COR,P.PESO,P.TAMANHO,P.CODIGOCATEGORIA,"
                + "C.NOME AS NOMECATEGORIA,"
                + "DP.CODIGOPEDIDO, DP.CODIGOPRODUTO, DP.QUANTIDADE, DP.PRECOUNITARIO, DP.DESCONTO FROM DETALHESPEDIDO DP "
                + "JOIN PRODUTO P ON DP.CODIGOPRODUTO = P.CODIGO "
                + "JOIN CATEGORIA C ON C.CODIGO = P.CODIGOCATEGORIA "
                + "WHERE DP.CODIGOPEDIDO = ?";
        stmt = con.prepareStatement(query);
        stmt.setLong(1, codigoPedido);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            Produto produto = new Produto();
            produto.setNome(rs.getString("nome"));
            produto.setCor(rs.getString("cor"));
            produto.setPeso(rs.getFloat("peso"));
            produto.setTamanho(rs.getString("tamanho"));
            produto.setCategoria(rs.getString("nomecategoria"));
            produto.setCodigo(rs.getString("codigoproduto"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setPreco(rs.getFloat("precounitario"));
            produto.setCodigoCategoria(rs.getLong("codigocategoria"));
            produto.setDesconto(rs.getFloat("desconto"));
            produtos.add(produto);
        }
        
        p.setProdutos(produtos);
        return p;
    }

}
