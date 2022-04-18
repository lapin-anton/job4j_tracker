package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подходящих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combineByName = (person) -> person.getName().contains(key);
        Predicate<Person> combineBySurname = (person) -> person.getSurname().contains(key);
        Predicate<Person> combineByPhone = (person) -> person.getPhone().contains(key);
        Predicate<Person> combineByAddress = (person) -> person.getAddress().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (var p: this.persons) {
            if (combineByName
                    .or(combineBySurname)
                    .or(combineByPhone)
                    .or(combineByAddress)
                    .test(p)
            ) {
                result.add(p);
            }
        }
        return result;
    }
}
