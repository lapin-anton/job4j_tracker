package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String buildingType;

    public Builder(String name, String surname, String education, String birthday, String[] technologies, String buildingType) {
        super(name, surname, education, birthday, technologies);
        this.buildingType = buildingType;
    }

    public Building build(String material) {
        return new Building(material);
    }
}
