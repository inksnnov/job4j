package ru.job4j.tracker;

/**
 * Реализация синглтона с помощью перечислений.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public enum SingleEagerTwo {
    /**
     * Перечисление.
     */
    INSTANCE;

    /**
     * Храним объект Tracker.
     */
    private Tracker tracker;

    /**
     * Создаем объект Tracker при загрузке класса.
     */
    private SingleEagerTwo() {
        this.tracker = new Tracker();
    }

    /**
     * Возвращаем объект Tracker.
     *
     * @return Tracker.
     */
    public Tracker getTracker() {
        return this.tracker;
    }
}
