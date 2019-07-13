package ru.job4j.tracker;

import java.util.List;

/**
 * Класс поиск заявок по имени.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class FindByNameItems extends BaseAction {

    /**
     * Конструктор инициализирует поля key и name.
     *
     * @param key  номер пункта меню.
     * @param name Описание пункта меню для вывода в консоль.
     */
    public FindByNameItems(int key, String name) {
        super(key, name);
    }

    /**
     * Реализация поиск заявкок по имени.
     *
     * @param input   {@link Input}.
     * @param tracker {@link Tracker}
     */

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Поиск заявок по имени.");
        String name = input.ask("Введите имя заявки : ");
        List<Item> items = tracker.findByName(name);
        for (Item item : items) {
            super.format(item.getName(), item.getDesc());
        }
    }
}
