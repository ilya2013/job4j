package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BankTest {

    @Test
    public void addOneUserAndOneAccountThenUserWithOneAccount() {
        String result = "";
        String expected = " |Реквизиты: 01, баланс: 0.0";
        User user1 = new User("Иван", "9212 556877");
        Bank bank = new Bank();
        bank.addUser(user1);
        Account account1 = new Account(0d, "01");
        bank.addAccountToUser(user1.getPassport(), account1);
        List<Account> accounts = bank.getUserAccounts(user1.getPassport());
        for (Account account : accounts) {
            result += " |" + account.toString();
        }
        assertThat(result, is(expected));
    }

    @Test
    public void addTwoUsersAnd3AccountsThenGetSecondUserWith2Accounts() {
        String result = "";
        String expected = " |Реквизиты: 02, баланс: 0.0 |Реквизиты: 03, баланс: 10.0";
        User user1 = new User("Иван", "9212 556877");
        User user2 = new User("Иван2", "9212 556878");
        Account account1 = new Account(0d, "01");
        Account account2 = new Account(0d, "02");
        Account account3 = new Account(10d, "03");
        Bank bank = new Bank();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        bank.addAccountToUser(user2.getPassport(), account3);
        List<Account> accounts = bank.getUserAccounts(user2.getPassport());
        for (Account account : accounts) {
            result += " |" + account.toString();
        }
        assertThat(result, is(expected));
    }

    @Test
    public void addTwoUsersAnd3AccountsWhenDeleteSecondUserThenStayFirstUser() {
        String result = "";
        String expected = "";
        User user1 = new User("Иван", "9212 556877");
        User user2 = new User("Иван2", "9212 556878");
        Account account1 = new Account(0d, "01");
        Account account2 = new Account(0d, "02");
        Account account3 = new Account(10d, "03");
        Bank bank = new Bank();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        bank.addAccountToUser(user2.getPassport(), account3);
        bank.deleteUser(user2);
        List<Account> accounts = bank.getUserAccounts(user2.getPassport());
        if (accounts.size() > 0) {
            for (Account account : accounts) {
                result += " |" + account.toString();
            }
        }
        assertThat(result, is(expected));
    }

    @Test
    public void addTwoUsersAnd3AccountsWhenTransfer10RubThenStayFirstUser() {
        String result = "";
        String expected = " |Реквизиты: 02, баланс: 10.0 |Реквизиты: 03, баланс: 55.0";
        User user1 = new User("Иван", "9212 556877");
        User user2 = new User("Иван2", "9212 556878");
        Account account1 = new Account(50d, "01");
        Account account2 = new Account(10d, "02");
        Account account3 = new Account(20d, "03");
        Bank bank = new Bank();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        bank.addAccountToUser(user2.getPassport(), account3);
        bank.transferMoney("9212 556877", "01", "9212 556878", "03", 35);
        List<Account> accounts = bank.getUserAccounts(user2.getPassport());
        if (accounts.size() > 0) {
            for (Account account : accounts) {
                result += " |" + account.toString();
            }
        }
        assertThat(result, is(expected));
    }
    @Test
    public void addTwoUsersAnd3AccountsWhenTransfer10RubThenStayFirstUser2() {
        String result = "";
        String expected = " |Реквизиты: 02, баланс: 10.0 |Реквизиты: 03, баланс: 20.0";
        User user1 = new User("Иван", "9212 556877");
        User user2 = new User("Иван2", "9212 556878");
        Account account1 = new Account(50d, "01");
        Account account2 = new Account(10d, "02");
        Account account3 = new Account(20d, "03");
        Bank bank = new Bank();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        bank.addAccountToUser(user2.getPassport(), account3);
        bank.transferMoney("9212 556877", "02", "9212 556878", "03", 35);
        List<Account> accounts = bank.getUserAccounts(user2.getPassport());
        if (accounts.size() > 0) {
            for (Account account : accounts) {
                result += " |" + account.toString();
            }
        }
        assertThat(result, is(expected));
    }
}