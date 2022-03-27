package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean hasDrillMachine;

    public Dentist(String name, String surname, String education, String birthday, boolean privatePractice, boolean hasDrillMachine) {
        super(name, surname, education, birthday, privatePractice);
        this.hasDrillMachine = hasDrillMachine;
    }

    public void doToothFilling(Patient patient) {
        patient.addToothFilling(new ToothFilling());
    }
}
