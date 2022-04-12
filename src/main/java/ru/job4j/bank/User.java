package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель клиента банка
 * @author Anton Lapin
 * @version 1.0
 */
public class User {
    /**
     * Данные паспорта клиента
     */
    private String passport;
    /**
     * Имя клиента
     */
    private String username;

    /**
     * Конструктор класса, принимает на вход данные паспорта и имя клиента
     * @param passport
     * @param username
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает данные паспорта клиента
     * @return
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает на вход данные паспорта и производит замену
     * текущих данных паспорта на новые
     * @param passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает имя клиента
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает на вход имя клиента и производит замену
     * текущего имени клиента
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
