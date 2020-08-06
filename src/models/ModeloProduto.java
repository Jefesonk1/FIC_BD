package models;

import java.util.List;

/**
 *
 * @author Jefeson
 */
public class ModeloProduto {

    private long codigoModelo;
    private String nomeModelo;
    private List<Descricao> descricao;

    public long getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(long codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public List<Descricao> getDescricao() {
        return descricao;
    }

    public void setDescricao(List<Descricao> descricao) {
        this.descricao = descricao;
    }
    
}
