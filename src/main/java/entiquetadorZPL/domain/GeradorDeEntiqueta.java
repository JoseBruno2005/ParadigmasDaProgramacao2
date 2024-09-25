package entiquetadorZPL.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class GeradorDeEntiqueta {

    public static String gerarEntiqueta(Produto produto){
        String descricaoCorreta = "";
        if(produto.getDescricao().length() > 22){
            descricaoCorreta = produto.getDescricao().substring(0, 22);
        } else{
            descricaoCorreta = produto.getDescricao();
        }

        String precoDaLata = "R$"+produto.getPrecoDaLata().replace(".", ",").concat("0");
        String precoDaCaixa = "R$"+produto.getPrecoDaCaixa().replace(".", ",").concat("0");

        return "^XA\n" +
                "^CFO,60\n" +
                "^FO50,50^FD"+descricaoCorreta+"^FS\n" +
                "^CFA,50\n" +
                "^FO50,200^FDLata     "+precoDaLata+"^FS\n" +
                "^FO50,280^FDCaixa    "+precoDaCaixa+"^FS\n" +
                "^BY5,2,270\n" +
                "^FO100,450^BC^FD"+produto.getCodigoDeBarras()+"^FS\n" +
                "^XZ";

    }

}
