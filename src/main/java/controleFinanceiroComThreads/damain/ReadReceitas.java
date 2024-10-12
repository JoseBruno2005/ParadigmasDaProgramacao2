package controleFinanceiroComThreads.damain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadReceitas {
    String caminhoArquivo = "src\\main\\java\\controleFinanceiroComThreads\\dataBaseCSV\\receitas.csv";
    String linha = "";
    HashMap<String, Double> receitas = new HashMap<>();
    boolean primeiraLinha = true;
    double valorTotalReceitas = 0;

    public String readReceitas(){
        try (BufferedReader br = new BufferedReader(new FileReader(this.caminhoArquivo))) {
            while ((this.linha = br.readLine()) != null) {
                if (this.primeiraLinha){
                    this.primeiraLinha = false;
                    continue;
                }

                String data = String.valueOf(this.linha.split(",")[0].split(" ")[0]);
                Double valorReceita = Double.valueOf(String.valueOf(this.linha.split(",")[1]).replace("\"", " ").trim());
                valorTotalReceitas += valorReceita;

                if (this.receitas.containsKey(data)){
                    double valorAntigo = this.receitas.get(data);
                    double valorAtualizado = valorAntigo + valorReceita;
                    this.receitas.put(data, valorAtualizado);
                }else {
                    this.receitas.put(data, valorReceita);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Depesas: " +
                this.receitas +
                "\nValor total das Receitas foram de: " + this.valorTotalReceitas;
    }

    public double getValorTotalReceitas() {
        return valorTotalReceitas;
    }
}
