package ru.job4j.stream;

public class Student implements Comparable<Student> {
    private String lastName = "Петя";
    private int score = 0;

    public Student(String lastName, int score) {
        this.lastName = lastName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public Student(int score) {
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getLastName() {
        return lastName;
    }

    public int compareTo(Student o) {
        return -1 * Integer.compare(this.score, o.score);
    }
}
