package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<User, List<Account>> clients = new HashMap<>();

    public void addUser(User user) {
        clients.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        clients.remove(user);
    }

    private User getUserByPassport (String passport) {
        User result = new User();
        for (Map.Entry<User, List<Account>> client : clients.entrySet()) {
            if (client.getKey().getPassport().equals(passport)) {
                result = client.getKey();
                break;
            }
        }
        return result;
    }

    private Map.Entry<User, List<Account>> getUserDataByPassport (String passport) {
        Map.Entry<User, List<Account>> result = null;
        for (Map.Entry<User, List<Account>> client : clients.entrySet()) {
            if (client.getKey().getPassport().equals(passport)) {
                result = client;
                break;
            }
        }
        return result;
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
        clients.get(getUserDataByPassport(passport).getKey()).remove(account);
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
        for (Map.Entry<User, List<Account>> client: clients.entrySet()) {
            List<Account> clientAccounts = client.getValue();
            if (clientAccounts != null) {
                for (Account account : clientAccounts) {
                    if (account.getRequisites().equals(req)) {
                        result = account;
                        break;
                    }
                }
            }
            if (result != null) {
                break;
            }
        }
        return result;
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
