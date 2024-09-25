package entiquetadorZPL.main;

import entiquetadorZPL.domain.GeradorDeEntiqueta;
import entiquetadorZPL.domain.Produto;
import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        GeradorDeEntiqueta geradorDeEntiqueta = new GeradorDeEntiqueta();

        Produto produto = new Produto("Cervaja Skol", 3.50,
                22.00, "78936683");

        String entiquetaZLP = geradorDeEntiqueta.gerarEntiqueta(produto);

        System.out.println(entiquetaZLP);
    }
}
