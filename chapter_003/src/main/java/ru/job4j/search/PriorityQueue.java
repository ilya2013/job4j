package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (!tasks.isEmpty()) {
            if (this.tasks.getLast().getPriority() < task.getPriority()) {
                tasks.addLast(task);
            } else if (this.tasks.getFirst().getPriority() > task.getPriority()) {
                tasks.addFirst(task);
            } else {
                for (int i = 1; i < tasks.size() - 1; i++) {
                    if (tasks.get(i).getPriority() >= task.getPriority()) {
                        tasks.add(i, task);
                    }
                }
            }
        } else {
            tasks.add(0, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}