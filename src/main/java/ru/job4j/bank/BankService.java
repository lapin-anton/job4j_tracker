package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банка, его с клиентами и их лицевыми счетами
 * @author Anton Lapin
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение информации о клиентах их лицевых счетах осуществляется в карте типа HashMap,
     * где ключ - User (клиент), значение по ключу - список лицевых счетов клиента из ключа.
     * Информация о лицевых счетах хранится в списке типа ArrayList.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход информацию о клиенте и добавляет ее
     * в хранилище данных о клиентах банка в случае, если информация о данном клиенте
     * еще не была туда добавлена.
     * @param user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход данные паспорта клиента и информацию о новом лицевом счете.
     * Метод ищет клиента банка по данным паспорта.
     * Если клиент был найден, то метод добавляет в список его счетов новый счет.
     * @param passport
     * @param account
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход данные паспорта и производит поиск в хранилище данных
     * о клиентах банка (в карте users).
     * @param passport
     * @return возвращает информацию о клиенте, у которого такие-же данные паспорта, либо null,
     * клиент не был найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход данные паспорта клиента и реквизиты лицевого счета.
     * Метод ищет клиента банка по данным паспорта.
     * Если клиент найден, то метод выполняет поиск лицевого счета по реквизитам
     * из списка счетов найденного клиента.
     * @param passport
     * @param requisite
     * @return возвращает информацию о лицевом счете клиента, либо null в случаях,
     * если клиент не был найден по данным паспорта или у найденного клиента не был
     * найден счет по указанным реквизитам
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value).stream()
                .filter(a -> a.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Метод принимает на вход данные паспорта клиента-отправителя, реквизиты счета-отправителя,
     * данные паспорта клиента-получателя, реквизиты счета-получателя, сумму транзакции.
     * Метод производит поиск счета-отправителя и счета-получателя.
     * Если счета найдены, то метод также проверяет, что текущий баланс счета-отправителя больше и равен
     * сумме транзакции. Если все условия выполняются, то метод производит списание суммы транзакции со
     * счета-отправителя и пополнение счета-получателя.
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return возвращает true, если транзакция выполнена успешно, false - транзакция не выполнена.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount;
        if (rsl) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        }
        return rsl;
    }
}
