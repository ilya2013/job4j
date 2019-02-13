package ru.job4j.bank;

import java.util.Objects;
public class User {

    private String name;
    private String passport;

    public User() {
    }

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
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
        return  Objects.equals(passport, user.passport);
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, паспорт: %", name, passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }
}
