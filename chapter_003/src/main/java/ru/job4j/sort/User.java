package ru.job4j.sort;

public class User implements Comparable<User> {
    private String name;
    private int age = 0;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User user) {
        return Integer.compare(this.getAge(), user.getAge());
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", возраст: " + age;
    }
}
