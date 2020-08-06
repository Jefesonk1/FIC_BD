package models;

import java.util.List;

/**
 *
 * @author Jefeson
 */
public class Descricao {

    private long codigoDesc;
    private String descricao;
    private long codigoModelo;
    private String siglaIdioma;
    private List<Idioma> idiomas;

    public long getCodigoDesc() {
        return codigoDesc;
    }

    public void setCodigo(long codigoDesc) {
        this.codigoDesc = codigoDesc;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(long codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public String getSiglaIdioma() {
        return siglaIdioma;
    }

    public void setSiglaIdioma(String siglaIdioma) {
        this.siglaIdioma = siglaIdioma;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

}
