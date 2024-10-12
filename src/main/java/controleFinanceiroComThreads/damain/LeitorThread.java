package controleFinanceiroComThreads.damain;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LeitorThread implements Runnable{

    private final Object leitor;
    private final CyclicBarrier barrier;

    public LeitorThread(Object leitor, CyclicBarrier barrier) {
        this.leitor = leitor;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            if (leitor instanceof ReadDespesas) {
                System.out.println(((ReadDespesas) leitor).readDespesa());
            } else if (leitor instanceof ReadReceitas) {
                System.out.println(((ReadReceitas) leitor).readReceitas());
            } else if (leitor instanceof ReadProvisao) {
                System.out.println(((ReadProvisao) leitor).readProvisao());
            }

            barrier.await();

            System.out.println(Thread.currentThread().getName() + " passou da barreira.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
