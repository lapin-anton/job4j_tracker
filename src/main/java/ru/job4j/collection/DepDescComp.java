package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        String[] units1 = o1.split("/");
        String[] units2 = o2.split("/");
        int len = Math.min(units1.length, units2.length);
        for (int index = 0; index < len; index++) {
            String s1 = units1[index];
            String s2 = units2[index];
            rsl = s1.compareTo(s2);
            if (index == 0 && rsl != 0) {
                rsl = Integer.compare(Integer.parseInt(s2.substring(s2.length() - 1)),
                        Integer.parseInt(s1.substring(s1.length() - 1)));
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(units1.length, units2.length);
        }
        return rsl;
    }
}
