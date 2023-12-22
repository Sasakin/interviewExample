package org.example.cuncurrency.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExampleTryLock {
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                if (lock1.tryLock()) {
                    System.out.println("Thread 1 acquired lock1");
                    Thread.sleep(1000);
                    if (lock2.tryLock()) {
                        System.out.println("Thread 1 acquired lock2");
                        // Делаем что-то с lock1 и lock2
                    } else {
                        System.out.println("Thread 1 failed to acquire lock2");
                    }
                } else {
                    System.out.println("Thread 1 failed to acquire lock1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                    System.out.println("Thread 1 released lock1");
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                    System.out.println("Thread 1 released lock2");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                if (lock2.tryLock()) {
                    System.out.println("Thread 2 acquired lock2");
                    Thread.sleep(1000);
                    if (lock1.tryLock()) {
                        System.out.println("Thread 2 acquired lock1");
                        // Делаем что-то с lock1 и lock2
                    } else {
                        System.out.println("Thread 2 failed to acquire lock1");
                    }
                } else {
                    System.out.println("Thread 2 failed to acquire lock2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                    System.out.println("Thread 2 released lock1");
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                    System.out.println("Thread 2 released lock2");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
