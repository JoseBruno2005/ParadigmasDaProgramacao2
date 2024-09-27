package softWareCalculadorDeImpostos.model;

public class Item {

    private int codigo;
    private String descricao;

    private double valor;

    private double impostoCalculado;

    private double total;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setImpostoCalculado(double impostoCalculado) {
        this.impostoCalculado = impostoCalculado;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public double getImpostoCalculado() {
        return impostoCalculado;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                "descricao='" + descricao + '\'' +
                "valor=" + valor +
                "impostoCalculado=" + impostoCalculado +
                "total=" + total;
    }
}
