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
            int startSize = tasks.size();
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getPriority() >= task.getPriority()) {
                    tasks.add(i, task);
                    break;
                }
            }
            if (startSize == tasks.size()) {
                tasks.addLast(task);
            }
        } else {
            tasks.add(0, task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}