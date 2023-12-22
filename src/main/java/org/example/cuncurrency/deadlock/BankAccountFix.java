package org.example.cuncurrency.deadlock;

public class BankAccountFix {
    public int id;
    private int balance;
    private final Object lock = new Object();

    public BankAccountFix(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }
    public BankAccountFix(int balance) {
        this.balance = balance;
    }

    public void transfer(BankAccountFix destinationAccount, int amount) {
        BankAccountFix firstAccount;
        BankAccountFix secondAccount;

        if (this.id < destinationAccount.id) {//if (this.hashCode() < destinationAccount.hashCode()) {
            firstAccount = this;
            secondAccount = destinationAccount;
        } else {
            firstAccount = destinationAccount;
            secondAccount = this;
        }

        synchronized (firstAccount.lock) {
            System.out.println(Thread.currentThread().getName() + " acquired lock on source account");

            synchronized (secondAccount.lock) {
                System.out.println(Thread.currentThread().getName() + " acquired lock on destination account");

                if (balance >= amount) {
                    balance -= amount;
                    destinationAccount.balance += amount;
                    System.out.println("Transfer successful!");
                } else {
                    System.out.println("Insufficient balance!");
                }
            }
        }
    }

    public static void main(String[] args) {
        BankAccountFix account1 = new BankAccountFix(1,100);
        BankAccountFix account2 = new BankAccountFix(2,200);

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
