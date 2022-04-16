package ru.job4j.function;

import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));
    }
}
