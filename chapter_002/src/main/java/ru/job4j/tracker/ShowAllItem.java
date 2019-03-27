package ru.job4j.tracker;

/**
 * Класс вывод всех заявок.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ShowAllItem extends FormatOut implements UserAction {

    /**
     * Ключ меню.
     *
     * @return int ключ.
     */
    @Override
    public int key() {
        return 3;
    }

    /**
     * Реализация вывод всех заявок.
     *
     * @param input   {@link Input}.
     * @param tracker {@link Tracker}
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Все заявки------------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            super.format(item.getName(), item.getDesc());
        }
    }

    /**
     * Показывает информация о действии этого класса в пункте меню.
     *
     * @return String действие.
     */
    @Override
    public String info() {
        return "3 - Показать все заявки.";
    }
}
