package controleFinanceiroComThreads.damain;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LeitorThread implements Runnable{

    private final Object leitor;  // Pode ser uma instância de ReadDespesas, ReadReceitas, ou ReadProvisao
    private final CyclicBarrier barrier;

    public LeitorThread(Object leitor, CyclicBarrier barrier) {
        this.leitor = leitor;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // Executa a leitura
            if (leitor instanceof ReadDespesas) {
                System.out.println(((ReadDespesas) leitor).readDespesa());
            } else if (leitor instanceof ReadReceitas) {
                System.out.println(((ReadReceitas) leitor).readReceitas());
            } else if (leitor instanceof ReadProvisao) {
                System.out.println(((ReadProvisao) leitor).readProvisao());
            }

            // Aguarda na barreira até que todas as threads terminem
            barrier.await();

            // Continua após todas as threads passarem pela barreira
            System.out.println(Thread.currentThread().getName() + " passou da barreira.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
