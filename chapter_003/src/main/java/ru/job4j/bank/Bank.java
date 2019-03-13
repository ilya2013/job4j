package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {
    private Map<User, List<Account>> clients = new HashMap<>();

    public void addUser(User user) {
        clients.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        clients.remove(user);
    }

    private User getUserByPassport(String passport) {
        User result = new User();
        Optional<User> optional;
        optional = clients.keySet().stream()
                .filter(e -> e.getPassport().equals(passport))
                .findAny();
        return optional.isPresent() ? optional.get() : result;
    }

    private Map.Entry<User, List<Account>> getUserDataByPassport(String passport) {
        Map.Entry<User, List<Account>> result = null;
        Optional<Map.Entry<User, List<Account>>> optional;
        optional = clients.entrySet().stream()
                .filter(entry -> entry.getKey().getPassport().equals(passport))
                .findAny();
        return optional.isPresent() ? optional.get() : result;
    }

    /**
     * Добавление нового счёта пользователю, с проверкой на наличие у пользователю счёта.
     * @param passport Номер, серия паспорта
     * @param account Счёт для добавления
     */
    public void addAccountToUser(String passport, Account account) {
        Map.Entry<User, List<Account>> entry = getUserDataByPassport(passport);
        if (entry != null && account != null && !entry.getValue().contains(account)) {
            clients.get(entry.getKey()).add(account);
        }
    }

    /**
     * Удаление счета пользователя.
     * @param passport паспорт пользователя
     * @param account счёт на удаление
     */
    public void deleteAccountFromUser(String passport, Account account) {
//        List<Account> accountList = clients.get(getUserByPassport(passport));
//        if (accountList != null) {
//            accountList.remove(account);
//        }
        Map.Entry<User, List<Account>> entry = getUserDataByPassport(passport);
        if (entry != null  && account != null && entry.getValue() != null) {
            List<Account> accountList = entry.getValue();
            accountList.remove(account);
            this.clients.put(entry.getKey(), accountList);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        Map.Entry<User, List<Account>> entry = getUserDataByPassport(passport);
        List<Account> result = new ArrayList<>();
        if (entry != null) {
            result = getUserDataByPassport(passport).getValue();
            if (result == null) {
                result = new ArrayList<>();
            }
        }
        return result;
    }

    private Account getAccountByReq(String req) {
        Account result = null;
        Optional<Account> optional;
        optional = clients.values().stream()
                .flatMap(List::stream)
                .filter(e -> e.getRequisites().equals(req))
                .findFirst();
        return optional.isPresent() ? optional.get() : result;
    }
    /**
     * Процедура перевода между счетами пользователей/пользователя.
     * @param srcRequisite Реквизиты счета списания.
     * @param dstRequisite Реквизиты счёта зачисления.
     * @param amount Сумма перевода.
     * @return перевод успешен.
     */
    public boolean transferMoney(String srcRequisite, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAccount = getAccountByReq(srcRequisite);
        Account dstAccount = getAccountByReq(dstRequisite);
        if ((srcAccount != null) && (dstAccount != null)) {
            result = srcAccount.transfer(dstAccount, amount);
        }
        return result;
    }
}
