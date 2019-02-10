package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SortUserTest {

    @Test
    public void checkAgeAsc() {
        SortUser users = new SortUser();
        String result = "";
        users.add(new User("Name1", 3));
        users.add(new User("Name2", 1));
        users.add(new User("Name3", 5));
        for (User user : users.getUsers()) {
            result += " | " + user.toString();
        }
        assertThat(result, is(" | Имя: Name2, возраст: 1 | Имя: Name1, возраст: 3 | Имя: Name3, возраст: 5"));
    }


    @Test
    public void sortNameLength2() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        String result = "";
        users.add(new User("Name14", 3));
        users.add(new User("Name2", 1));
        users.add(new User("Name3", 5));
        for (User user : sortUser.sortNameLength(users)) {
            result += " | " + user.toString();
        }
        assertThat(result, is(" | Имя: Name2, возраст: 1 | Имя: Name3, возраст: 5 | Имя: Name14, возраст: 3"));
    }

    @Test
    public void sortByAllFields() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        String result = "";
        users.add(new User("Сергей", 25));
        users.add(new User("Иван", 30));
        users.add(new User("Сергей", 20));
        users.add(new User("Иван", 25));
        for (User user : sortUser.sortByAllFields(users)) {
            result += " | " + user.toString();
        }
        assertThat(result, is(" | Имя: Иван, возраст: 25 | Имя: Иван, возраст: 30 | Имя: Сергей, возраст: 20 | Имя: Сергей, возраст: 25"));
    }
}