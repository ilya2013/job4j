package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {
    Map<User, Object> userMap = new HashMap<>();
    User user1 = new User("Петр", 0, new GregorianCalendar(1992, Calendar.APRIL, 01));
    User user2 = new User("Петр", 0, new GregorianCalendar(1992, Calendar.APRIL, 01));
@Test
    public void whenAddTwoSameEmentsThenGetMapWithTwoElements() {
    userMap.put(user1, "1");
    userMap.put(user2, "2");
    userMap.forEach((a, b) -> System.out.printf("Ключ: %s, значение: %s%s", a, b, System.lineSeparator()));

}
}