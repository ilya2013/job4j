package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
   public List<Student> collect(List<Student> students, Predicate<Student> predict) {
       return students.stream().filter(student -> predict.test(student)).collect(Collectors.toList());
   };

    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(student -> student.getLastName(),
                                                            student -> student));
    };

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted()
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScore() >= bound)
                .collect(Collectors.toList());
    };

}
