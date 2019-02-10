package ru.job4j.sort;

import java.util.*;

public class SortUser {
    private Set<User> users = new TreeSet<>();

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void add(User user) {
        this.users.add(user);
//        return true;
    }

    public List<User> sortNameLength(List<User> users) {
        //List<User> result = new ArrayList<>();
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName()) != 0 ? o1.getName().compareTo(o2.getName()) : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return users;
    }

    public Set<User> getUsers() {
        return users;
    }
}
