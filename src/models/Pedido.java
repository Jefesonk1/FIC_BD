package models;

import java.sql.Timestamp;

/**
 *
 * @author Jefeson
 */
public class Pedido {

    private int codigo;
    private Timestamp dtpedido;
    private Timestamp dtenvio;
    private Timestamp dtrecebimento;
    private int codigoCliente;
    private String contaCliente;
    private int numeroCartaoCredito;
    private String codigoConfirmacao;
    private int codigoVendedor;
    private float imposto;
    private int enderecoFatura;
    private int enderecoEntrega;
    private int codigoTransportadora;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getContaCliente() {
        return contaCliente;
    }

    public void setContaCliente(String contaCliente) {
        this.contaCliente = contaCliente;
    }

    public int getNumeroCartaoCredito() {
        return numeroCartaoCredito;
    }

    public void setNumeroCartaoCredito(int numeroCartaoCredito) {
        this.numeroCartaoCredito = numeroCartaoCredito;
    }

    public String getCodigoConfirmacao() {
        return codigoConfirmacao;
    }

    public void setCodigoConfirmacao(String codigoConfirmacao) {
        this.codigoConfirmacao = codigoConfirmacao;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public float getImposto() {
        return imposto;
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }

    public int getEnderecoFatura() {
        return enderecoFatura;
    }

    public void setEnderecoFatura(int enderecoFatura) {
        this.enderecoFatura = enderecoFatura;
    }

    public int getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(int enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public int getCodigoTransportadora() {
        return codigoTransportadora;
    }

    public void setCodigoTransportadora(int codigoTransportadora) {
        this.codigoTransportadora = codigoTransportadora;
    }
}
