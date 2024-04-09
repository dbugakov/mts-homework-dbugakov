package RandomRace;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                long startTime = System.currentTimeMillis();
                List<Integer> integers = new ArrayList<>();
                Random random = new Random();
                for (int j = 0; j < 5000000; j++) {
                    integers.add(random.nextInt());
                }
                long timeSpent = System.currentTimeMillis() - startTime;
                map.put("Thread " + finalI, timeSpent);
                System.out.println("Thread " + finalI + " выполнялась " + timeSpent + " миллисекунд, создано " + integers.size() + " чисел");
            }, "Thread " + i);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
        Optional<Map.Entry<String, Long>> winnerThread = map.entrySet().stream()
                .min(Map.Entry.comparingByValue());
        if (winnerThread.isPresent()) {
            System.out.println("Потоком, который выполнился быстрее всего, оказался " + winnerThread.get().getKey()
                    + ", который завершился за " + winnerThread.get().getValue() + " миллисекунд!");
        } else {
            System.out.println("Что-то пошло не так, результатов гонки нет");
        }

    }
}
