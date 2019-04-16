package ru.job4j.tracker;

/**
 * Синглтон lazy loading - реализация через внутренний статический класс.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SingleLazyTwo {

    /**
     * Храним объект Tracker.
     */
    private Tracker tracker;

    /**
     * Создание объекта Tracker.
     */
    private SingleLazyTwo() {
        this.tracker = new Tracker();
    }

    /**
     * Возвращаем объект класса SingleLazyTwo.
     *
     * @return SingleLazyTwo.
     */
    public static SingleLazyTwo getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Возвращаем объект Tracker.
     *
     * @return Tracker.
     */
    public Tracker getTracker() {
        return this.tracker;
    }

    /**
     * Внутренний класс хранит созданный объект SingleLazyTwo.
     */
    private static final class Holder {

        /**
         * Создаем объект класса SingleLazyTwo.
         */
        private static final SingleLazyTwo INSTANCE = new SingleLazyTwo();
    }
}
