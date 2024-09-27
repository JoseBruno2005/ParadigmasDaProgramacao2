package softWareCalculadorDeImpostos;

import softWareCalculadorDeImpostos.factory.ImpostoFactory;
import softWareCalculadorDeImpostos.factory.TipoImposto;
import softWareCalculadorDeImpostos.imposto.Imposto;
import softWareCalculadorDeImpostos.model.Item;
import softWareCalculadorDeImpostos.model.Produto;
import softWareCalculadorDeImpostos.model.Servico;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> listaDeItens = new ArrayList<>();

        Imposto impostoICMS = new ImpostoFactory().getImposto(TipoImposto.TIPOICMS);
        Imposto impostoIPI = new ImpostoFactory().getImposto(TipoImposto.TIPOIPI);
        Imposto impostoISS = new ImpostoFactory().getImposto(TipoImposto.TIPOISS);
        Imposto impostoPIS = new ImpostoFactory().getImposto(TipoImposto.TIPOPIS);

        Produto produto1 = new Produto();
        produto1.setCodigo(1);
        produto1.setDescricao("Caixa Cerveja Skol");
        produto1.setValor(30);
        produto1.setIndustrial(true);
        produto1.setImpostoCalculado(impostoICMS.calcular(produto1));
        produto1.setTotal(produto1.getValor() + produto1.getImpostoCalculado());

        Produto produto2 = new Produto();
        produto2.setCodigo(2);
        produto2.setDescricao("Celular quebrado");
        produto2.setValor(15.00);
        produto2.setIndustrial(true);
        produto2.setImpostoCalculado(impostoPIS.calcular(produto1));
        produto2.setTotal(produto2.getValor() + produto2.getImpostoCalculado());

        Produto produto3 = new Produto();
        produto3.setCodigo(3);
        produto3.setDescricao("Pamonha");
        produto3.setValor(3.50);
        produto3.setIndustrial(false);
        produto3.setImpostoCalculado(impostoIPI.calcular(produto1));
        produto3.setTotal(produto3.getValor() + produto3.getImpostoCalculado());

        Servico servico = new Servico();
        servico.setCodigo(4);
        servico.setDescricao("Corte de Cabelo");
        servico.setValor(25.00);
        servico.setImpostoCalculado(impostoISS.calcular(servico));
        servico.setTotal(servico.getValor() + servico.getImpostoCalculado());

        listaDeItens.add(produto1);
        listaDeItens.add(produto2);
        listaDeItens.add(produto3);
        listaDeItens.add(servico);

        double valorTotalDosItens = 0;
        double valorTotalDosImpostosDosProdutos = 0;
        double valorTotalDosImpostosDosSevicos = 0;


        for (int i = 0; i < listaDeItens.size(); i ++){
            System.out.println(listaDeItens.get(i).toString());
            if (listaDeItens.get(i) instanceof Servico){
                valorTotalDosImpostosDosSevicos += listaDeItens.get(i).getImpostoCalculado();
            }else {
                valorTotalDosImpostosDosProdutos += listaDeItens.get(i).getImpostoCalculado();
            }
            valorTotalDosItens += listaDeItens.get(i).getTotal();
        }

        System.out.println("Valor total dos Itens~: " + valorTotalDosItens);
        System.out.println("Valor total dos impostos dos seviços: " + valorTotalDosImpostosDosSevicos);
        System.out.println("Valor total dos impostos dos produto: " + valorTotalDosImpostosDosProdutos);


    }
}
