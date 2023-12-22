package org.example.cuncurrency.compareandset;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CompareAndSetAlgorithm {
    private static final AtomicReference<Integer> value = new AtomicReference<>(0);

    public static void main(String[] args) {
        int expectedValue = 0;
        int newValue = 1;

        while (true) {
            int currentValue = value.get();
            if (currentValue == expectedValue) {
                if (value.compareAndSet(currentValue, newValue)) {
                    System.out.println("Value updated successfully");
                    break;
                } else {
                    System.out.println("Value update failed");
                }
            } else {
                System.out.println("Concurrent modification detected");
                break;
            }
        }
    }
}
