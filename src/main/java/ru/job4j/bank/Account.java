package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель лицевого счета клиента банка
 * @author Anton Lapin
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета
     */
    private String requisite;
    /**
     * Информация о текущем балансе счета
     */
    private double balance;

    /**
     * Конструктор класса, принимает на вход реквизиты и начальный баланс
     * лицевого счета
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает реквизиты лицевого счета
     * @return
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход новые реквизиты лицевого счета и производит замену
     * текущих реквизитов на новые
     * @param requisite
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает текущий баланс лицевого счета
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход новое значение баланса и заменяет значение
     * текущего баланса на новое
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
