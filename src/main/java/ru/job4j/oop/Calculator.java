package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int rsl1 = Calculator.sum(10);
        System.out.println(rsl1);
        Calculator calculator = new Calculator();
        int rsl2 = calculator.multiply(5);
        System.out.println(rsl2);
        int rsl3 = Calculator.minus(10);
        System.out.println(rsl3);
        int rsl4 = calculator.divide(5);
        System.out.println(rsl4);
        int rsl5 = calculator.sumAllOperation(10);
        System.out.println(rsl5);
    }

}
