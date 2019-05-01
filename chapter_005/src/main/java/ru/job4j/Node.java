package ru.job4j;

class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        Node turtle = first;
        Node hare = first;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }
}
