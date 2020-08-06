package models;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Jefeson
 */
public class Pedido {

    private long codigo;
    private Timestamp dtpedido;
    private Timestamp dtenvio;
    private Timestamp dtrecebimento;
    private long codigoCliente;
    private String contaCliente;
    private long numeroCartaoCredito;
    private String codigoConfirmacao;
    private long codigoVendedor;
    private float imposto;
    private long codigoEnderecoFatura;
    private long CodigoEnderecoEntrega;
    private long codigoTransportadora;
    private List<Produto> produtos;
    private Cliente cliente;
    private Transportadora trasportadora;
    private Endereco enderecoFatura;
    private Endereco enderecoEntrega;
    private Vendedor vendedor;

    
    public Pedido(){
        cliente = new Cliente();
        trasportadora = new Transportadora();
        enderecoFatura = new Endereco();
        enderecoEntrega = new Endereco();
        vendedor = new Vendedor();      
        
    }
    
    public float somarPedido(){
        float soma=0.0f;
        
        for (Produto produto : produtos) {
            soma += produto.getPreco()*produto.getQuantidade()-produto.getDesconto();
        }
        soma += imposto;
        return soma;
    }
    
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Timestamp getDtpedido() {
        return dtpedido;
    }

    public void setDtpedido(Timestamp dtpedido) {
        this.dtpedido = dtpedido;
    }

    public Timestamp getDtenvio() {
        return dtenvio;
    }

    public void setDtenvio(Timestamp dtenvio) {
        this.dtenvio = dtenvio;
    }

    public Timestamp getDtrecebimento() {
        return dtrecebimento;
    }

    public void setDtrecebimento(Timestamp dtrecebimento) {
        this.dtrecebimento = dtrecebimento;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getContaCliente() {
        return contaCliente;
    }

    public void setContaCliente(String contaCliente) {
        this.contaCliente = contaCliente;
    }

    public long getNumeroCartaoCredito() {
        return numeroCartaoCredito;
    }

    public void setNumeroCartaoCredito(long numeroCartaoCredito) {
        this.numeroCartaoCredito = numeroCartaoCredito;
    }

    public String getCodigoConfirmacao() {
        return codigoConfirmacao;
    }

    public void setCodigoConfirmacao(String codigoConfirmacao) {
        this.codigoConfirmacao = codigoConfirmacao;
    }

    public long getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(long codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public float getImposto() {
        return imposto;
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }

    public long getCodigoEnderecoFatura() {
        return codigoEnderecoFatura;
    }

    public void setCodigoEnderecoFatura(long codigoEnderecoFatura) {
        this.codigoEnderecoFatura = codigoEnderecoFatura;
    }

    public long getCodigoEnderecoEntrega() {
        return CodigoEnderecoEntrega;
    }

    public void setCodigoEnderecoEntrega(long CodigoEnderecoEntrega) {
        this.CodigoEnderecoEntrega = CodigoEnderecoEntrega;
    }

    public long getCodigoTransportadora() {
        return codigoTransportadora;
    }

    public void setCodigoTransportadora(long codigoTransportadora) {
        this.codigoTransportadora = codigoTransportadora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Transportadora getTrasportadora() {
        return trasportadora;
    }

    public void setTrasportadora(Transportadora trasportadora) {
        this.trasportadora = trasportadora;
    }

    public Endereco getEnderecoFatura() {
        return enderecoFatura;
    }

    public void setEnderecoFatura(Endereco enderecoFatura) {
        this.enderecoFatura = enderecoFatura;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

   

}
