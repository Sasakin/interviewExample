package org.example.cuncurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        // Создание ExecutorService с FixedThreadPool
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Запуск потоков
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskId + " is running.");
                // Выполнение задачи
                // ...
                System.out.println("Task " + taskId + " is completed.");
            });
        }

        //Thread.sleep(1000);

        // Завершение ExecutorService
        //executorService.shutdown();  //executorService.awaitTermination(1000l, TimeUnit.MILLISECONDS);

        //System.out.println("Start ExecutorService");

        // Запуск потоков
        for (int i = 20; i < 30; i++) {
            final int taskId = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskId + " is running.");
                // Выполнение задачи
                // ...
                System.out.println("Task " + taskId + " is completed.");
            });
        }
    }
}
