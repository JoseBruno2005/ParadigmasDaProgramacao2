package softWareCalculadorDeImpostos.imposto;

import softWareCalculadorDeImpostos.model.Item;
import softWareCalculadorDeImpostos.model.Produto;

public class IPI implements Imposto{

    @Override
    public double calcular(Item item) {
        if(item instanceof Produto && ((Produto) item).industrial == true){
            return item.getValor() * 0.12;
        } else if (item instanceof Produto && ((Produto) item).industrial == false) {
            return item.getValor();
        } else {
            throw new IllegalArgumentException("IPI só pode ser aplicado em um produto!");
        }
    }
}
