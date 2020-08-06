package models;

import java.sql.Timestamp;

/**
 *
 * @author Jefeson
 */
public class Vendedor {

    private long codigo;
    private String primeiroNome;
    private String nomeDoMeio;
    private String sobrenome;
    private String senha;
    private Timestamp dtNascimento;
    private Timestamp dtContratacao;
    private String sexo;
    private float quota;
    private float bonus;
    private float comissao;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Timestamp getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Timestamp dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Timestamp getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(Timestamp dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getQuota() {
        return quota;
    }

    public void setQuota(float quota) {
        this.quota = quota;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

}
