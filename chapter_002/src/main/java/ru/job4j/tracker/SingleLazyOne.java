package ru.job4j.tracker;

/**
 * Синглтон lazy loading
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SingleLazyOne {

    /**
     * Храним объект SingleLazyOne.
     */
    private static SingleLazyOne instance;

    /**
     * Храним объект Tracker.
     */
    private Tracker tracker;

    /**
     * Создание объекта Tracker.
     */
    private SingleLazyOne() {
        this.tracker = new Tracker();
    }

    /**
     * Проверяем не создано ли объекта SingleLazyOne, если не создано возвращаем созданный объект.
     *
     * @return SingleLazyOne.
     */
    public static SingleLazyOne getInstance() {
        if (instance == null) {
            instance = new SingleLazyOne();
        }
        return instance;
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
