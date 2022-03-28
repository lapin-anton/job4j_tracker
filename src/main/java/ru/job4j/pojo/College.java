package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Studentov Student Studentovich");
        student.setGroup("1-37");
        student.setAdmission(LocalDate.parse("2020-09-01"));
        System.out.printf("Student info: \n\tfio: %s\n\tgroup: %s\n\tadmission date: %s%n",
                student.getFio(), student.getGroup(), student.getAdmission());
    }
}
