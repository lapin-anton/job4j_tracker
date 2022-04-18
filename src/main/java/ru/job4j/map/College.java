package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (var s: students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        var student = findByAccount(account);
        if (student.isPresent()) {
            var subjects = students.get(student.get());
            for (var subj : subjects) {
                if (name.equals(subj.getName())) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        var college = new College(students);
        var student = college.findByAccount("000001");
        student.ifPresent(value -> System.out.println("Найденный студент: " + value));
        Optional<Subject> english = college.findBySubjectName("000001", "English");
        english.ifPresent(subject -> System.out.println("Оценка по найденному предмету: " + subject.getScore()));
    }
}
