package controleFinanceiroComThreads.main;

import controleFinanceiroComThreads.damain.LeitorThread;
import controleFinanceiroComThreads.damain.ReadDespesas;
import controleFinanceiroComThreads.damain.ReadProvisao;
import controleFinanceiroComThreads.damain.ReadReceitas;

import java.util.concurrent.CyclicBarrier;


public class main {
    public static void main(String[] args) {

        final int NUM_THREADS = 3;

        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            System.out.println("Todas as threads terminaram suas tarefas. Calculando resultados finais...");
        });

        var lerReceita = new ReadReceitas();
        var lerDespesa = new ReadDespesas();

        Thread despesasThread = new Thread(new LeitorThread(lerDespesa, barrier), "DespesasThread");
        Thread receitasThread = new Thread(new LeitorThread(lerReceita, barrier), "ReceitasThread");
        Thread provisaoThread = new Thread(new LeitorThread(new ReadProvisao(), barrier), "ProvisaoThread");

        despesasThread.start();
        receitasThread.start();
        provisaoThread.start();

        try {
            despesasThread.join();
            receitasThread.join();
            provisaoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double totalReceitas = lerReceita.getValorTotalReceitas();
        double totalDespesas = lerDespesa.getValorTotalDespesa();
        double resultadoFinal = totalReceitas - totalDespesas;
        System.out.println("Total Receitas: " + totalReceitas);
        System.out.println("Total Despesas: " + totalDespesas);
        System.out.println("Resultado Financeiro: " + resultadoFinal);

    }
}
