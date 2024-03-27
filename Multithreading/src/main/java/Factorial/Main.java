package Factorial;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {

        int factorialNumber = 13;
        int threadCount = 2;
        int chunkSize = Math.round((float) factorialNumber / threadCount);

        ExecutorService exec = Executors.newFixedThreadPool(threadCount);
        Future<Integer>[] futures = new Future[threadCount];

        Integer[] list = new Integer[factorialNumber];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i + 1) * chunkSize;
            futures[i] = exec.submit(new FactorialTask(list, startIndex, endIndex));
        }

        int resultValue = 1;
        for (Future<Integer> future : futures) {
            try {
                resultValue *= future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Multi thread result: " + resultValue);

        System.out.println("Single thread result: " + new FactorialTask(list, 0, factorialNumber).call());
        exec.shutdown();
    }
}
