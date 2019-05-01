package ru.job4j.list;

public class SimpleQueue<T> {
    private int size = 0;
    private SimpleStack<T> simpleStack = new SimpleStack<T>();
    private SimpleStack<T> reversedSimpleStack = new SimpleStack<T>();
    private T result;
    public T poll() {
        result = null;
        if (reversedSimpleStack.size() != 0) {
            result = reversedSimpleStack.poll();
            size--;
        } else if (size != 0) {
            reverseStack();
            result = reversedSimpleStack.poll();
            size--;
        }
        return result;
    }
    protected void reverseStack() {
        for (int i = 0; i < this.size; i++) {
            reversedSimpleStack.push(simpleStack.poll());
        }
    }

    public void push(T value) {
        simpleStack.push(value);
        size++;
    }
}
