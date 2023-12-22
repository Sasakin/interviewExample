package org.example.cuncurrency.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamForkJoinExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ForkJoinPool customThreadPool = new ForkJoinPool(4); // Создание ручного пула потоков

        int sum = customThreadPool.submit(() ->
                Arrays.stream(array)
                        .parallel() // Включение параллельного выполнения
                        .sum()
        ).join();

        System.out.println("Sum: " + sum);
    }
}
