package models;

/**
 *
 * @author Jefeson
 */
public class Transportadora {

    private long codigo;
    private String nome;
    private float taxaBase;
    private float taxaEnvio;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTaxaBase() {
        return taxaBase;
    }

    public void setTaxaBase(float taxaBase) {
        this.taxaBase = taxaBase;
    }

    public float getTaxaEnvio() {
        return taxaEnvio;
    }

    public void setTaxaEnvio(float taxaEnvio) {
        this.taxaEnvio = taxaEnvio;
    }
}
