package org.example.cuncurrency.lambda;

public class LambdaExample {

    public static void main(String[] args) {
        new LambdaExample().runLambda(2,3);
    }

    public void runLambda(int a, int b) {

        a = 1;
        b = 3;
        // Пример лямбда-выражения
        MyFunctionalInterface myLambda = (x, y) -> x + y;

        // Вызов лямбда-выражения
        int result = myLambda.calculate(a, b);
        System.out.println("Result: " + result);
    }
}



@FunctionalInterface
interface MyFunctionalInterface {
    int calculate(int x, int y);
}
