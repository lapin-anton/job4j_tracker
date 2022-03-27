package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String[] technologies;

    public Engineer(String name, String surname, String education, String birthday, String[] technologies) {
        super(name, surname, education, birthday);
        this.technologies = technologies;
    }

    public Project createProject(Specification specification) {
        return new Project(specification);
    }
}
