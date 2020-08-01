package models;

/**
 *
 * @author Jefeson
 */
public class Transportadora {

    private int codigo;
    private String nome;
    private float taxaBase;
    private float taxaEnvio;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
