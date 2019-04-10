package ru.job4j.list;

public class SimpleStack<T>  {
    private final SimpleArrayList<T> stack = new SimpleArrayList<>();

    public T poll() {
        return stack.delete();
    }

    public void push(T value) {
        stack.add(value);
    };
}
