package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> contacts = new HashMap<>();
        contacts.put("ya@gmail.com", "Lev Nikolaevich Tolstoy");
        contacts.put("ya@gmail.com", "Aleksey Nikolaevich Tolstoy");
        contacts.put("pushkin@mail.ru", "Aleksander Sergeevich Pushkin");
        System.out.println("Using Map.Entry object...");
        for (Map.Entry<String, String> pair: contacts.entrySet()) {
            System.out.printf("Email: %s, full name: %s %n", pair.getKey(), pair.getValue());
        }
        System.out.println("Using keySet method...");
        for (String key: contacts.keySet()) {
            System.out.printf("Email: %s, full name: %s %n", key, contacts.get(key));
        }
    }
}
