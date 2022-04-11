package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int length = Math.min(left.length(), right.length());
        for (int index = 0; index < length; index++) {
            rsl += Character.compare(left.charAt(index), right.charAt(index));
        }
        return rsl == 0 ? Integer.compare(left.length(), right.length()) : rsl;
    }
}
