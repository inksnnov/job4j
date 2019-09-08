package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

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
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("Поиск заявок по имени.");
        String name = input.ask("Введите имя заявки : ");
        List<Item> items = tracker.findByName(name);
        for (Item item : items) {
            output.accept(super.format(item.getName(), item.getDesc()));
        }
    }
}
