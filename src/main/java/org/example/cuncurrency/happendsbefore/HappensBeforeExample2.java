package org.example.cuncurrency.happendsbefore;

import java.io.UnsupportedEncodingException;

public class HappensBeforeExample2 {
    private static boolean flag = false;

    private static int a = 0;
    private static int b = 0;
    private static int r1 = 0;
    private static int r2 = 0;


    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            System.out.println("Поток записи записывает данные...");
            flag = true;
            System.out.println("Поток записи завершил запись данных.");
        });
        Thread readerThread = new Thread(() -> {
            while (!flag) {
                // Ожидание, пока флаг не станет true
            }
            System.out.println("Поток чтения обнаружил флаг как true.");
        });
        writerThread.start();
        readerThread.start();
    }
}
