package org.example.cuncurrency.doublecheckedlocking;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Приватный конструктор
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println("Thread 1: " + singleton.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println("Thread 2: " + singleton.hashCode());
        });

        thread1.start();
        thread2.start();
    }
}
