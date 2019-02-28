package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> students = Arrays.asList(new Student("Костя",  10),
             new Student("Федя",  70),
             new Student("Иван", 40),
             new Student("Саша", 60),
             new Student("Таня", 100),
             new Student("Петя", 55)
    );

    @Test
    public void collectAClass() {
        List<Student> result;
        Predicate<Student> isA = (student -> student.getScore() >= 70 && student.getScore() <= 100);
        School school = new School();
        result = school.collect(students, isA);
        List expected = Arrays.asList(students.get(1), students.get(4));
        assertThat(result, is(expected));
    }

    @Test
    public void collectBClass() {
        List<Student> result;
        Predicate<Student> isB = (student -> student.getScore() >= 50 && student.getScore() < 70);
        School school = new School();
        result = school.collect(students, isB);
        List expected = Arrays.asList(students.get(3), students.get(5));
        assertThat(result, is(expected));
    }

    @Test
    public void collectCClass() {
        List<Student> result;
        Predicate<Student> isC = (student -> student.getScore() < 50);
        School school = new School();
        result = school.collect(students, isC);
        List expected = Arrays.asList(students.get(0), students.get(2));
        assertThat(result, is(expected));
    }

    @Test
    public void collectStudentMap() {
        Map<String, Student> result;
        School school = new School();
        result = school.collectToMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put(students.get(0).getLastName(), students.get(0));
        expected.put(students.get(1).getLastName(), students.get(1));
        expected.put(students.get(2).getLastName(), students.get(2));
        expected.put(students.get(3).getLastName(), students.get(3));
        expected.put(students.get(4).getLastName(), students.get(4));
        expected.put(students.get(5).getLastName(), students.get(5));
        assertThat(result, is(expected));
    }


}