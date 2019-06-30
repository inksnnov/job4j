package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Очередь с приоритетом на LinkedList.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class PriorityQueue {

    /**
     * Храним очередь.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод добавляет в очередь задание по порядку, в зависимости от
     * приоритета task.getPriority от 1 до 5.
     *
     * @param task Задание.
     */
    public void put(Task task) {
        ListIterator<Task> iter = this.tasks.listIterator();
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
        } else if (task.getPriority() >= this.tasks.getLast().getPriority()) {
            this.tasks.add(task);
        } else {
            while (iter.hasNext()) {
                if (task.getPriority() <= iter.next().getPriority()) {
                    iter.previous();
                    iter.add(task);
                    break;
                }
            }
        }
    }

    /**
     * Забрать задание по приоритету с начала списка и удалить его из списка.
     *
     * @return задание.
     */
    public Task take() {
        return this.tasks.poll();
    }
}
