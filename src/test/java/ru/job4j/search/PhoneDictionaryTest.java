package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Feodor", "Bondarchuk", "666666", "Moscow")
        );
        var persons = phones.find("Petr");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Arsentev");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenNotFindBySurname() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Feodor", "Bondarchuk", "666666", "Moscow")
        );
        var persons = phones.find("Galkin");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("534872");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenNotFindByPhone() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Feodor", "Bondarchuk", "666666", "Moscow")
        );
        var persons = phones.find("123456");
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Bryansk");
        assertThat(persons.get(0).getName(), is("Petr"));
    }

    @Test
    public void whenNotFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Feodor", "Bondarchuk", "666666", "Moscow")
        );
        var persons = phones.find("Kemerovo");
        assertThat(persons.size(), is(0));
    }
}