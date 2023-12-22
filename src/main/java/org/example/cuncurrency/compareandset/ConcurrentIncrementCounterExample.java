package org.example.cuncurrency.compareandset;

public class ConcurrentIncrementCounterExample {

    private static int index = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1  = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    index++;
                    System.out.println(Thread.currentThread().getName() + " index: " + index);
                }
            }
        });
        thread1.setName("Thread 1");

        Thread thread2  = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500000; i++) {
                    index++;
                    System.out.println(Thread.currentThread().getName() + " index: " + index);
                }
            }
        });
        thread1.setName("Thread 2");


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(Thread.currentThread().getName() + " index: " + index);
    }
}
