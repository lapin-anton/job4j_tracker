package ru.job4j.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        LinkedHashSet<String> temp = new LinkedHashSet<>();
        for (String dep: deps) {
            String start = "";
            for (String unit: dep.split("/")) {
                temp.add(start + unit);
                start += unit + "/";
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(new DepAscComp());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
