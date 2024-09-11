package projetoCarrinho.main;

import projetoCarrinho.domain.Carrinho;
import projetoCarrinho.domain.Produto;

public class App {

    public static void main(String[] args) {

        var carrinho = new Carrinho();

        carrinho.inserirItens(new Produto("Cigarro", "001", "Mata", 10f));
        carrinho.inserirItens(new Produto("Maconha", "002", "Chapa", 15f));

        carrinho.descontoNoProduto("001", 2.0f);

        carrinho.setAcrescimoTotal(10);
        carrinho.setDescontoTotal(4);

        carrinho.finalizarVenda();

    }

}
