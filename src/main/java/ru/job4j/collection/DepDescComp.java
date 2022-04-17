package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] units1 = o1.split("/");
        String[] units2 = o2.split("/");
        int rsl = units2[0].compareTo(units1[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
