package Factorial;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Integer> {
    private final Integer[] array;
    private final int start;
    private final int end;

    public FactorialTask(Integer[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        Integer resultValue = 1;
        for (int i = start; i < end; i++) {
            if (i < array.length) resultValue *= array[i];
        }
        return resultValue;
    }
}
