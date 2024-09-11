package projetoCarrinho.domain;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    float acrescimoTotal;
    float descontoTotal;
    float valorTotal;
    List<Produto> listaDeProdutos = new ArrayList<>();

    public String inserirItens(Produto produto){
        this.listaDeProdutos.add(produto);
        return produto.getNome() + " adicionado!";
    }

    public void acrescimoNoProduto(String codigo, float acrescimo){
        for (Produto produto : listaDeProdutos){
            if(produto.getCodigo().equalsIgnoreCase(codigo)){
                float precoAtualizado = produto.getPreco() + acrescimo;
                produto.setPreco(precoAtualizado);
                float acrescimoTotal = produto.getAcrescimo() + acrescimo;
                produto.setAcrescimo(acrescimoTotal);
                System.out.println("Valor de " + produto.getNome() + " Atualizado para " + produto.getPreco());
            }
        }
    }

    public void descontoNoProduto(String codigo, float desconto){
        for (Produto produto : listaDeProdutos){
            if(produto.getCodigo().equalsIgnoreCase(codigo) && produto.getPreco() > desconto){
                float precoAtualizado = produto.getPreco() - desconto;
                produto.setPreco(precoAtualizado);
                float descontoTotal = produto.getDesconto() + desconto;
                produto.setDesconto(descontoTotal);
                System.out.println("Valor de " + produto.getNome() + " Com desconto é de " + produto.getPreco());
            }
        }
    }

    public void setAcrescimoTotal(float acrescimoTotal){

        float valorParaCadaProduto = acrescimoTotal/listaDeProdutos.size();

        for(Produto produto: listaDeProdutos){
            float precoAtualizado = produto.getPreco() + valorParaCadaProduto;
            produto.setPreco(precoAtualizado);
            float acrescimo = produto.getAcrescimo() + valorParaCadaProduto;
            produto.setAcrescimo(acrescimo);
        }

    }

    public void setDescontoTotal(float descontoTotal){

        float valorParaCadaProduto = descontoTotal/listaDeProdutos.size();

        for(Produto produto: listaDeProdutos) {
            if (produto.getPreco() > valorParaCadaProduto) {
                float precoAtualizado = produto.getPreco() - valorParaCadaProduto;
                produto.setPreco(precoAtualizado);
                float desconto = produto.getDesconto() + valorParaCadaProduto;
                produto.setDesconto(desconto);
            }
        }

    }

    public void finalizarVenda(){
        for (Produto produto : listaDeProdutos){
            acrescimoTotal += produto.getAcrescimo();
            descontoTotal += produto.getDesconto();
            valorTotal += produto.getPreco();
            System.out.println(produto.toString());
        }
        System.out.println("Acrescimo Total: " + this.acrescimoTotal);
        System.out.println("Desconto Total: " + this.descontoTotal);
        System.out.println("Valor Total: " + this.valorTotal);
    }

}
