package ru.job4j.bank;

import java.util.Objects;

public class Account {
    private double value;
    private String requisites;

    public Account() {

    }
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
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
        return requisites.equals(account.requisites);
    }

    @Override
    public String toString() {
        return String.format("Реквизиты: %s, баланс: %s", requisites, value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }

    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (!this.equals(destination) && amount > 0 && amount < this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }

    public String getRequisites() {
        return requisites;
    }
}
