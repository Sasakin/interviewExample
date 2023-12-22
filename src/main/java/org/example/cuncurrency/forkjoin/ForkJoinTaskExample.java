package org.example.cuncurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskExample extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10;
    private int[] array;
    private int start;
    private int end;

    public ForkJoinTaskExample(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // Выполнение вычислений напрямую
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Разделение задачи на подзадачи
            int mid = (start + end) / 2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(array, start, mid);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(array, mid, end);

            leftTask.fork(); // Асинхронное выполнение левой подзадачи
            int rightResult = rightTask.compute(); // Выполнение правой подзадачи синхронно
            int leftResult = leftTask.join(); // Получение результата левой подзадачи

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTaskExample task = new ForkJoinTaskExample(array, 0, array.length);
        int result = forkJoinPool.invoke(task);

        System.out.println("Sum: " + result);
    }
}
