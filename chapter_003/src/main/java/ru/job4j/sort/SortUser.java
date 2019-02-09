package ru.job4j.sort;

import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    private Set<User> users = new TreeSet<>();

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void add(User user) {
        this.users.add(user);
//        return true;
    }


    public Set<User> getUsers() {
        return users;
    }
}
