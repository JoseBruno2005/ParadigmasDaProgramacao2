package projetoCarrinho.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    // Variáveis globais
    static List<Map<String, Object>> listaDeProdutos = new ArrayList<>();
    static float acrescimoTotal = 0;
    static float descontoTotal = 0;
    static float valorTotal = 0;

    //criar produto
    public static Map<String, Object> criarProduto(String nome, String codigo, String descricao, float preco) {
        Map<String, Object> produto = new HashMap<>();
        produto.put("nome", nome);
        produto.put("codigo", codigo);
        produto.put("descricao", descricao);
        produto.put("preco", preco);
        produto.put("acrescimo", 0f);
        produto.put("desconto", 0f);
        return produto;
    }

    //inserir item na lista
    public static String inserirItens(Map<String, Object> produto) {
        listaDeProdutos.add(produto);
        return produto.get("nome") + " adicionado!";
    }

    //acréscimo em um produto
    public static void acrescimoNoProduto(String codigo, float acrescimo) {
        for (Map<String, Object> produto : listaDeProdutos) {
            if (produto.get("codigo").equals(codigo)) {
                float precoAtualizado = (float) produto.get("preco") + acrescimo;
                produto.put("preco", precoAtualizado);
                float acrescimoAtualizado = (float) produto.get("acrescimo") + acrescimo;
                produto.put("acrescimo", acrescimoAtualizado);
                System.out.println("Valor de " + produto.get("nome") + " Atualizado para " + precoAtualizado);
            }
        }
    }

    //desconto em um produto
    public static void descontoNoProduto(String codigo, float desconto) {
        for (Map<String, Object> produto : listaDeProdutos) {
            if (produto.get("codigo").equals(codigo) && (float) produto.get("preco") > desconto) {
                float precoAtualizado = (float) produto.get("preco") - desconto;
                produto.put("preco", precoAtualizado);
                float descontoAtualizado = (float) produto.get("desconto") + desconto;
                produto.put("desconto", descontoAtualizado);
                System.out.println("Valor de " + produto.get("nome") + " Com desconto é de " + precoAtualizado);
            }
        }
    }

    //acréscimo total
    public static void setAcrescimoTotal(float acrescimoTotal) {
        float valorParaCadaProduto = acrescimoTotal / listaDeProdutos.size();

        for (Map<String, Object> produto : listaDeProdutos) {
            float precoAtualizado = (float) produto.get("preco") + valorParaCadaProduto;
            produto.put("preco", precoAtualizado);
            float acrescimoAtualizado = (float) produto.get("acrescimo") + valorParaCadaProduto;
            produto.put("acrescimo", acrescimoAtualizado);
        }
    }

    //desconto total
    public static void setDescontoTotal(float descontoTotal) {
        float valorParaCadaProduto = descontoTotal / listaDeProdutos.size();

        for (Map<String, Object> produto : listaDeProdutos) {
            if ((float) produto.get("preco") > valorParaCadaProduto) {
                float precoAtualizado = (float) produto.get("preco") - valorParaCadaProduto;
                produto.put("preco", precoAtualizado);
                float descontoAtualizado = (float) produto.get("desconto") + valorParaCadaProduto;
                produto.put("desconto", descontoAtualizado);
            }
        }
    }

    // Função para finalizar a venda
    public static void finalizarVenda() {
        for (Map<String, Object> produto : listaDeProdutos) {
            acrescimoTotal += (float) produto.get("acrescimo");
            descontoTotal += (float) produto.get("desconto");
            valorTotal += (float) produto.get("preco");
            System.out.println("Nome: " + produto.get("nome"));
            System.out.println("Codigo: " + produto.get("codigo"));
            System.out.println("Descrição: " + produto.get("descricao"));
            System.out.println("Acrescimo: " + produto.get("acrescimo"));
            System.out.println("Desconto: " + produto.get("desconto"));
            System.out.println("Preço: " + produto.get("preco"));
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
        System.out.println("Acrescimo Total: " + acrescimoTotal);
        System.out.println("Desconto Total: " + descontoTotal);
        System.out.println("Valor Total: " + valorTotal);
    }

    public static void main(String[] args) {
        Map<String, Object> p1 = criarProduto("Produto1", "001", "Descrição do Produto 1", 10);
        Map<String, Object> p2 = criarProduto("Produto2", "002", "Descrição do Produto 2", 5);

        System.out.println(inserirItens(p1));
        System.out.println(inserirItens(p2));

        acrescimoNoProduto("001", 10);
        descontoNoProduto("002", 20);

        setAcrescimoTotal(30);
        setDescontoTotal(40);

        finalizarVenda();
    }
}
