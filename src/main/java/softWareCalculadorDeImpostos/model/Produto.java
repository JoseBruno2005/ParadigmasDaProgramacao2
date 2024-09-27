package softWareCalculadorDeImpostos.model;

public class Produto extends Item{

    public  boolean industrial;

    public void setIndustrial(boolean industrial) {
        this.industrial = industrial;
    }

    @Override
    public String toString() {
        return super.toString() + "" +
                "industrial=" + industrial +
                '}';
    }
}
