package org.example.cuncurrency.doublecheckedlocking;

public class SingletonSinch {
    private static volatile SingletonSinch instance;

    private SingletonSinch() {
        // Приватный конструктор
    }

    public static SingletonSinch getInstance() {
        if (instance == null) {
            synchronized (SingletonSinch.class) {
                if (instance == null) {
                    instance = new SingletonSinch();
                }
            }
        }
        return instance;
    }
}
