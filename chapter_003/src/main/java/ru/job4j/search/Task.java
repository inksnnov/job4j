package ru.job4j.search;

/**
 * Класс каркас задания.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Task {

    /**
     * Описание задания.
     */
    private String desc;

    /**
     * Приоритет задания.
     */
    private int priority;

    /**
     * Заполняем поля класса.
     *
     * @param desc     задание.
     * @param priority приоритет.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Возвращаем описание задания.
     *
     * @return this.desc.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Возвращаем приоритет задания.
     *
     * @return this.priority.
     */
    public int getPriority() {
        return this.priority;
    }
}
