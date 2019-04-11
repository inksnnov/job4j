package ru.job4j.tracker;

/**
 * Класс поиск заявки по ID.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class FindByIdItem extends BaseAction {

    /**
     * Конструктор инициализирует поля key и name.
     *
     * @param key  номер пункта меню.
     * @param name Описание пункта меню для вывода в консоль.
     */
    public FindByIdItem(int key, String name) {
        super(key, name);
    }

    /**
     * Реализация поиск заявки по ID.
     *
     * @param input   {@link Input}.
     * @param tracker {@link Tracker}
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Поиск заявки по ID");
        String id = input.ask("Введите номер заявки");
        Item item = tracker.findById(id);
        if (item != null) {
            super.format(item.getName(), item.getDesc());
        } else {
            System.out.println("Заявка не найдена, укажите верный ID.");
        }
    }
}
