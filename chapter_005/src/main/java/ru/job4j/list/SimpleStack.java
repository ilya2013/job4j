package ru.job4j.list;

public class SimpleStack<T>  {
    private int size;
    private SimpleStack.Node<T> first;

    public T poll() {
        T result = first != null ? first.date : null;
            this.first = this.first != null && this.first.next != null ? this.first.next : null;
        return result;
    }

    public void push(T value) {
        Node<T> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    };

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E date;
        SimpleStack.Node<E> next;

        Node(E date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return date.toString();
        }
    }
}
