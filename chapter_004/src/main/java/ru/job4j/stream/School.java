package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
   public List<Student> collect(List<Student> students, Predicate<Student> predict) {
       return students.stream().filter(student -> predict.test(student)).collect(Collectors.toList());
   };

    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(student -> student.getLastName(),
                                                            student -> student));
    };
}
