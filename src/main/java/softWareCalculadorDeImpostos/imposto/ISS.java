package softWareCalculadorDeImpostos.imposto;

import softWareCalculadorDeImpostos.model.Item;
import softWareCalculadorDeImpostos.model.Servico;

public class ISS implements Imposto{

    @Override
    public double calcular(Item item) {
        if(item instanceof Servico){
            return item.getValor() * 0.22;
        }else{
            throw new IllegalArgumentException("ISS só pode ser aplicado em um Serviço!");
        }
    }
}
