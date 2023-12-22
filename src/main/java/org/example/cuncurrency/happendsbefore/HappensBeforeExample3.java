package org.example.cuncurrency.happendsbefore;

public class HappensBeforeExample3 {
    private static volatile int counter = 0;

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread incrementThread = new Thread(() -> {
            // Увеличиваем счетчик на 1

            while (counter!=100) {
                counter++;
            }
            //flag = true;
        });

        Thread printThread = new Thread(() -> {
            // Выводим значение счетчика
            while (counter!=100) {
                System.out.println("Counter value: " + counter);
            }
        });

        // Запускаем потоки
        incrementThread.start();
        printThread.start();

        // Ожидаем завершения потоков
        incrementThread.join();
        printThread.join();
    }
}
