package entiquetadorZPL.domain;

public class Produto {

    private String descricao;
    private Double precoDaLata;
    private Double precoDaCaixa;
    private String codigoDeBarras;

    public Produto(String descricao, Double precoDaLata, Double precoDaCaixa, String codigoDeBarras) {
        this.descricao = descricao;
        this.precoDaLata = precoDaLata;
        this.precoDaCaixa = precoDaCaixa;
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrecoDaLata() {
        return String.valueOf(precoDaLata);
    }

    public String  getPrecoDaCaixa() {
        return String.valueOf(precoDaCaixa);
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }
}
