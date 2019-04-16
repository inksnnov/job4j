package ru.job4j.tracker;

/**
 * Синглтон eager loading.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SingleEagerOne {

    /**
     * Создаем объект класса после загрузки JVM.
     */
    private static final SingleEagerOne INSTANCE = new SingleEagerOne();

    /**
     * Храним объект Tracker.
     */
    private Tracker tracker;

    /**
     * Создаем объект Tracker при загрузке класса.
     */
    private SingleEagerOne() {
        this.tracker = new Tracker();
    }

    /**
     * Возвращаем объект SingleEagerOne.
     *
     * @return SingleEagerOne.
     */
    public static SingleEagerOne getInstance() {
        return INSTANCE;
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
