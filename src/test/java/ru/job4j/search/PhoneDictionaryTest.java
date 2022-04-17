package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Feodor", "Bondarchuk", "666666", "Moscow")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Arsentev");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenNotFindBySurname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Feodor", "Bondarchuk", "666666", "Moscow")
        );
        ArrayList<Person> persons = phones.find("Galkin");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("534872");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenNotFindByPhone() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Feodor", "Bondarchuk", "666666", "Moscow")
        );
        ArrayList<Person> persons = phones.find("123456");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Bryansk");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenNotFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Feodor", "Bondarchuk", "666666", "Moscow")
        );
        ArrayList<Person> persons = phones.find("Kemerovo");
        assertThat(persons.size(), is(0));
    }
}