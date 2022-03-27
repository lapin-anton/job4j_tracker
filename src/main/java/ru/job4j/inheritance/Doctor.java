package ru.job4j.inheritance;

public class Doctor extends Profession {

    private boolean privatePractice;

    public Doctor(String name, String surname, String education, String birthday, boolean privatePractice) {
        super(name, surname, education, birthday);
        this.privatePractice = privatePractice;
    }

    public boolean isPrivatePractice() {
        return privatePractice;
    }
}
