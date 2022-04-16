package ru.job4j.lambda;

import java.util.function.Function;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            total = add(
                    (cur) -> cur + num, total
            );
        }
        System.out.println(total);
    }

    private static Integer add(Function<Integer, Integer> calc, int total) {
        return calc.apply(total);
    }
}
