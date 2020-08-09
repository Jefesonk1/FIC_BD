package report;

/**
 *
 * @author Jefeson
 */
public class RelatorioQuotaReport {
    String nome;
    float quota;
    float vendas;
    String inicio;
    String fim;
    
    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getQuota() {
        return quota;
    }

    public void setQuota(float quota) {
        this.quota = quota;
    }

    public float getVendas() {
        return vendas;
    }

    public void setVendas(float vendas) {
        this.vendas = vendas;
    }
    
}
