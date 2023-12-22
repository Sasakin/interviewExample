package org.example.cuncurrency.forkjoin;

import java.util.Arrays;

public class ParallelStreamExample {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum = Arrays.stream(array)
                .parallel() // Включение параллельного выполнения
                .sum();

        System.out.println("Sum: " + sum);
    }
}
