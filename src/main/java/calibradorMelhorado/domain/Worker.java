package calibradorMelhorado.domain;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Worker implements Runnable{

    private final List<String> calibrations;
    private final AtomicInteger soma;
    private final AtomicInteger count;
    private final CountDownLatch latch;

    public Worker(List<String> calibrations, AtomicInteger soma, AtomicInteger count, CountDownLatch latch) {
        this.calibrations = calibrations;
        this.soma = soma;
        this.count = count;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            int somaParcial = 0;
            int countParcial = 0;

            for (String line : calibrations) {
                somaParcial += Calibrador.valorCalibracao(line);
                countParcial++;
            }
            soma.addAndGet(somaParcial);
            count.addAndGet(countParcial);

            System.out.println(Thread.currentThread().getName() + " completou o processamento.");
        } finally {
            latch.countDown();
        }
    }

}
