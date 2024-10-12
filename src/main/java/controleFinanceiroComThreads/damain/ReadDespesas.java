package controleFinanceiroComThreads.damain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadDespesas {

    String caminhoArquivo = "src\\main\\java\\controleFinanceiroComThreads\\dataBaseCSV\\despesas.csv";
    String linha = "";
    HashMap<String, Double> despesas = new HashMap<>();
    boolean primeiraLinha = true;

    double valorTotalDespesa = 0;

    public String readDespesa(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.caminhoArquivo))) {
            while ((this.linha = br.readLine()) != null) {
                if (this.primeiraLinha){
                    this.primeiraLinha = false;
                    continue;
                }

                String data = String.valueOf(this.linha.split(",")[0].split(" ")[0]);
                Double valorDespesa = Double.valueOf(String.valueOf(this.linha.split(",")[1]).replace("\"", " ").trim());
                valorTotalDespesa += valorDespesa;

                if (this.despesas.containsKey(data)){
                    double valorAntigo = this.despesas.get(data);
                    double valorAtualizado = valorAntigo + valorDespesa;
                    this.despesas.put(data, valorAtualizado);
                }else {
                    this.despesas.put(data, valorDespesa);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Depesas: " +
                this.despesas +
                "\nValor total das despesa foram de: " + this.valorTotalDespesa;
    }

    public double getValorTotalDespesa() {
        return valorTotalDespesa;
    }
}
