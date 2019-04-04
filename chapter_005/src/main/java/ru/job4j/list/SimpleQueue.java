package ru.job4j.list;

public class SimpleQueue<T> {
    private int size = 0;
    private SimpleStack<T> simpleStack = new SimpleStack<T>();
    private SimpleStack<T> reversedSimpleStack = new SimpleStack<T>();
    private T result;
    public T poll() {
        for (int i = 0; i < this.size; i++) {
            reversedSimpleStack.push(simpleStack.poll());
        }
        size--;
        result = reversedSimpleStack.poll();
        for (int i = 0; i < this.size; i++) {
            simpleStack.push(reversedSimpleStack.poll());
        }
        return result;
    }

    public void push(T value) {
        simpleStack.push(value);
        size++;
    }
}
