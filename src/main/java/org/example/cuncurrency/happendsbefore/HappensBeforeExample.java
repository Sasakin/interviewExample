package org.example.cuncurrency.happendsbefore;

public class HappensBeforeExample {
    private static int counter = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            counter = 1; // Запись значения 1 в переменную counter
            flag = true; // Запись значения true в переменную flag
            if (flag) { // Чтение значения переменной flag
                counter = 3;
                System.out.println("Counter: " + counter); // Чтение значения переменной counter
            }
        });

        Thread readerThread = new Thread(() -> {
            counter = 2;

            if (flag) { // Чтение значения переменной flag
                System.out.println("Counter: " + counter); // Чтение значения переменной counter
            }
        });


        writerThread.start();
        readerThread.start();

        /*writerThread.join();
        readerThread.join();*/
    }
}
