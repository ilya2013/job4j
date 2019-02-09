package ru.job4j.sort;

import org.junit.Test;

import java.util.Arrays;

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
}