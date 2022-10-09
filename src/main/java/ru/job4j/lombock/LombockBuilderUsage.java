package ru.job4j.lombock;

public class LombockBuilderUsage {

    public static void main(String[] args) {
        Permission permission = Permission.of()
                .id(1)
                .name("Admin")
                .rules("create")
                .rules("rename")
                .rules("delete")
                .build();
    }

}
