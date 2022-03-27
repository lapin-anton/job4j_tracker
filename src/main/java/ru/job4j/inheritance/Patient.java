package ru.job4j.inheritance;

import java.util.List;

public class Patient {

    private List<ToothFilling> toothFillings;
    private List<Surgery> surgeries;

    public void addToothFilling(ToothFilling t) {
        this.toothFillings.add(t);
    }

    public void undergoSurgery(Surgery surgery) {
        this.surgeries.add(surgery);
    }

}
