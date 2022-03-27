package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String[] tools;

    public Surgeon(String name, String surname, String education, String birthday, boolean privatePractice, String[] tools) {
        super(name, surname, education, birthday, privatePractice);
        this.tools = tools;
    }

    public void doSurgery(Patient patient) {
        patient.undergoSurgery(new Surgery());
    }
}
