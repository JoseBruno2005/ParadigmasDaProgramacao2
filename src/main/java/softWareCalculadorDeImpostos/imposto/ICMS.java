package softWareCalculadorDeImpostos.imposto;


import softWareCalculadorDeImpostos.model.Item;
import softWareCalculadorDeImpostos.model.Produto;

public class ICMS implements Imposto{
    @Override
    public double calcular(Item item) {
        if(item instanceof Produto){
            return item.getValor() * 0.18;
        }else {
            throw new IllegalArgumentException("ICMS só pode ser aplicado em um produto!");
        }
    }
}
