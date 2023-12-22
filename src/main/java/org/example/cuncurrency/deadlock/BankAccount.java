package org.example.cuncurrency.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance;
    private final Object lock = new Object();

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public static  void transfer(BankAccount firstAccount, BankAccount secondAccount, int amount) {
        BankAccount first = firstAccount.hashCode() < secondAccount.hashCode() ? firstAccount : secondAccount;
        BankAccount second = firstAccount.hashCode() >= secondAccount.hashCode() ? firstAccount : secondAccount;

        synchronized (first) {
            System.out.println(Thread.currentThread().getName() + " acquired lock on source account");

            synchronized (second) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on destination account");

                if (first.balance >= amount) {
                    first.balance -= amount;
                    secondAccount.balance += amount;
                    System.out.println("Transfer successful!");
                } else {
                    System.out.println("Insufficient balance!");
                }
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(100);
        BankAccount account2 = new BankAccount(200);

        Thread thread1 = new Thread(() -> {
            account1.transfer(account2, 50);
        });

        Thread thread2 = new Thread(() -> {
            account2.transfer(account1, 70);
        });

        thread1.start();
        thread2.start();
    }
}
