package softWareCalculadorDeImpostos.imposto;


import softWareCalculadorDeImpostos.model.Item;
import softWareCalculadorDeImpostos.model.Produto;

public class PIS implements Imposto{

    @Override
    public double calcular(Item item) {
        if(item instanceof Produto){
            return item.getValor() * 0.0065;
        }else {
            throw new IllegalArgumentException("PIS só pode ser aplicado em um produto!");
        }
    }
}
