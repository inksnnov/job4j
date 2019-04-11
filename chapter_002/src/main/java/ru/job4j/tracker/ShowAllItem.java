package ru.job4j.tracker;

/**
 * Класс вывод всех заявок.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ShowAllItem extends BaseAction {

    /**
     * Конструктор инициализирует поля key и name.
     *
     * @param key  номер пункта меню.
     * @param name Описание пункта меню для вывода в консоль.
     */
    public ShowAllItem(int key, String name) {
        super(key, name);
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
}
