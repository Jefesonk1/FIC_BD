package models;

import java.sql.Timestamp;

/**
 *
 * @author Jefeson
 */
public class Produto extends ModeloProduto {

    private String codigo;
    private String nome;
    private String cor;
    private float custoProducao;
    private float preco;
    private String tamanho;
    private float peso;
    private long codigoCategoria;
    private Timestamp dtInicioVenda;
    private Timestamp dtFimVenda;
    private String categoria;
    private int quantidade;
    private float desconto;

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getCustoProducao() {
        return custoProducao;
    }

    public void setCustoProducao(float custoProducao) {
        this.custoProducao = custoProducao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public long getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(long codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Timestamp getDtInicioVenda() {
        return dtInicioVenda;
    }

    public void setDtInicioVenda(Timestamp dtInicioVenda) {
        this.dtInicioVenda = dtInicioVenda;
    }

    public Timestamp getDtFimVenda() {
        return dtFimVenda;
    }

    public void setDtFimVenda(Timestamp dtFimVenda) {
        this.dtFimVenda = dtFimVenda;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
