package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String language;

    public Programmer(String name, String surname, String education, String birthday, String[] technologies, String language) {
        super(name, surname, education, birthday, technologies);
        this.language = language;
    }

    public App writeApp(String name) {
        return new App(name);
    }
}
