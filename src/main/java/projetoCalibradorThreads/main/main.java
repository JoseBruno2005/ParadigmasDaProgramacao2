package projetoCalibradorThreads.main;

import projetoCalibradorThreads.domain.CalibradorComThreads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService poolDeThreads = Executors.newFixedThreadPool(3);

        long tempoInicial = System.currentTimeMillis();
         var calibradorThreads = new CalibradorComThreads();

        Path path = Paths.get(System.getProperty("user.dir") + "\\src\\main\\java\\projetoCalibradorThreads\\calibrador\\new_calibration_text.txt");
        List<String> calibrations = Files.readAllLines(path);

        AtomicInteger soma = new AtomicInteger();
        AtomicInteger count = new AtomicInteger();

        for (String line: calibrations) {
            poolDeThreads.execute(() -> {
                soma.addAndGet(calibradorThreads.valorCalibracao(line));
                count.getAndIncrement();
            });
        }

        poolDeThreads.shutdown();
        poolDeThreads.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("A soma dos valores é: " + soma);
        System.out.println("Total de linhas: " + count);

        long tempoFinal = System.currentTimeMillis();

        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
    }
}
