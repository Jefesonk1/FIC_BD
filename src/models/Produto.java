package models;

import java.sql.Timestamp;

/**
 *
 * @author Jefeson
 */
public class Produto {
    private String codigo;
    private String nome;
    private String cor;
    private float custoProducao;
    private float preco;
    private String tamanho;
    private float peso;
    private int codigoModelo;
    private int codigoCategoria;
    private Timestamp dtInicioVenda;
    private Timestamp dtFimVenda;

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

    public int getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(int codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
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
}
