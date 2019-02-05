package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void process() {
        List<User> users = new ArrayList();
        for (int i = 0; i < 3; i++) {
            users.add(i,
                    new User(i, "User" + i, "City" + i)
                        );
        }
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(0, new User(0, "User0", "City0"));
        expected.put(1, new User(1, "User1", "City1"));
        expected.put(2, new User(2, "User2", "City2"));
        HashMap<Integer, User> result = new UserConvert().process(users);
        assertThat(result, is(expected));

    }
}