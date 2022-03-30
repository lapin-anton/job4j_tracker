package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        String[] predictions = new String[] {"Да", "Нет", "Может быть"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        sc.nextLine();
        int answer = new Random().nextInt(3);
        System.out.println(predictions[answer]);
    }
}
