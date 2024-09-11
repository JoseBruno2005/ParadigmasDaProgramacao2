package projetoCarrinho.domain;

public class Produto {

    String nome;
    String codigo;
    String descricao;
    float acrescimo = 0;
    float desconto = 0;
    float preco;

    public Produto(String nome, String codigo, String descricao, float preco){
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
                "Codigo: " + this.codigo + "\n" +
                "Descrição: " + this.descricao + "\n" +
                "Acrescimo: " + this.acrescimo + "\n" +
                "Desconto: " + this.desconto + "\n" +
                "Preço: " + this.preco + "\n" +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
    }
}
