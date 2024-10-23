package balanca.services;



import balanca.exception.*;
import balanca.interfaces.IBalanca;
import balanca.models.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UranoIntegra implements IBalanca<Produto>{

    @Override
    public void exportar(List<Produto> produtos, String pastaArquivoTxt) {
        File directory = new File(pastaArquivoTxt);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pastaArquivoTxt + "/PRODUTOS.TXT"))) {
            for (Produto produto : produtos) {
                String linha = formatarProduto(produto);
                writer.write(linha);
                writer.newLine();
            }
        } catch (DiretorioInvalido e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String formatarProduto(Produto produto) {
        if (produto == null || produto.getDescricao() == null || produto.getTipo() == null) {
            throw new ProdutoOuCamposNulos();
        }
        if (produto.getCodigo() <= 0) {
            throw new CodigoProdutoInvalido();
        }
        if (produto.getDescricao().length() < 3) {
            throw new DescricaoProdutoInvalida();
        }
        if (!produto.getTipo().equals("6") && !produto.getTipo().equals("9")) {
            throw new TipoProdutoInvalido();
        }
        if (produto.getValor() <= 0) {
            throw new ValorProdutoInvalido();
        }
        try{
            String codigo = String.format("%06d", produto.getCodigo());
            String flag = "*";
            String tipo = "9".equals(produto.getTipo()) ? "0" : "6"; // 9 coloquei como se fosse para o peso
            String descricao = String.format("%-20s", produto.getDescricao());
            String preco = String.format("%09.2f", produto.getValor()).replace(".", ",");

            return codigo + flag + tipo + descricao + preco + "00000D";
        }catch (NumberFormatException e){
            throw new NumberFormatException("Erro ao formatar os valores do produto.");
        }
    }
}


