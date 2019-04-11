package ru.job4j.tracker;

/**
 * Класс добавления заявки.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class AddItem extends BaseAction {

    /**
     * Конструктор инициализирует поля key и name.
     *
     * @param key  номер пункта меню.
     * @param name Описание пункта меню для вывода в консоль.
     */
    public AddItem(int key, String name) {
        super(key, name);
    }

    /**
     * Реализация добавления новой заявки.
     *
     * @param input   {@link Input}.
     * @param tracker {@link Tracker}
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Добавление новой заявки------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("Заявка успешно добавлена.");
    }
}
