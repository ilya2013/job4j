package ru.job4j;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return getId() == user.getId()
                && getName().equals(user.getName())
                && getCity().equals(user.getCity());
    }

    @Override
    public String toString() {
        return id + name + city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCity());
    }

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
