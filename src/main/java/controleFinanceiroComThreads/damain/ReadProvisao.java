package controleFinanceiroComThreads.damain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadProvisao {
    String caminhoArquivo = "src\\main\\java\\controleFinanceiroComThreads\\dataBaseCSV\\provisao.csv";
    String linha = "";
    HashMap<String, Double> provisao = new HashMap<>();
    boolean primeiraLinha = true;
    double valorTotalProvisao = 0;

    public String readProvisao(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.caminhoArquivo))) {
            while ((this.linha = br.readLine()) != null) {
                if (this.primeiraLinha){
                    this.primeiraLinha = false;
                    continue;
                }

                String data = String.valueOf(this.linha.split(",")[0].split(" ")[0]);
                Double valorProvisao = Double.valueOf(String.valueOf(this.linha.split(",")[1]).replace("\"", " ").trim());
                valorTotalProvisao += valorProvisao;

                if (this.provisao.containsKey(data)){
                    double valorAntigo = this.provisao.get(data);
                    double valorAtualizado = valorAntigo + valorProvisao;
                    this.provisao.put(data, valorAtualizado);
                }else {
                    this.provisao.put(data, valorProvisao);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Depesas: " +
                this.provisao +
                "\nValor total das Provisão foram de: " + this.valorTotalProvisao;
    }
}
