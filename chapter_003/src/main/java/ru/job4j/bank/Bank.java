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

    /**
     * Добавление нового счёта пользователю, с проверкой на наличие у пользователю счёта.
     * @param passport Номер, серия паспорта
     * @param account Счёт для добавления
     */
    public void addAccountToUser(String passport, Account account) {
        User searchUser = new User("1", passport);
        if (!clients.get(searchUser).contains(account)) {
            clients.get(searchUser).add(account);
        }
    }

    /**
     * Удалени счетов пользователя.
     * @param passport паспорт пользователя
     * @param account счёт на удаление
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User searchUser = new User("1", passport);
        clients.get(searchUser).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result;
        try {
            result = clients.get(new User("1", passport));
            result.size();
        } catch (Exception e) {
            result = new ArrayList<>();
        }
        return result;
    }

    private Account getActualAccount(User user, String req) {
        Account result;
        List<Account> list = this.clients.get(user);
        try {
            result = list.get(list.indexOf(new Account(0d, req)));
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            result = null;
        }
        return result;
    }
    /**
     * Процедура перевода между счетами пользователей/пользователя. Происходит проверка принадлежности счета пользователю.
     * @param srcPassport Паспорт отправителя.
     * @param srcRequisite Реквизиты счета списания.
     * @param destPassport Паспорт получателя.
     * @param dstRequisite Реквизиты счёта зачисления.
     * @param amount Сумма перевода.
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        User searchSrcUser = new User("1", srcPassport);
        User searchDestUser = new User("2", destPassport);
        if (this.clients.containsKey(searchSrcUser) && this.clients.containsKey(searchDestUser)) {
            Account srcAccount = getActualAccount(searchSrcUser, srcRequisite);
            Account dstAccount = getActualAccount(searchDestUser, dstRequisite);
            if ((srcAccount != null) && (dstAccount != null)) {
                result = srcAccount.transfer(dstAccount, amount);
            }
        }
        return result;
    }
}
