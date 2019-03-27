package ru.job4j.tracker;

/**
 * Класс поиск заявок по имени.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class FindByNameItems extends FormatOut implements UserAction {

    /**
     * Ключ меню.
     *
     * @return int ключ.
     */
    @Override
    public int key() {
        return 4;
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
        Item[] items = tracker.findByName(name);
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
        return "4 - Поиск заявок по имени.";
    }
}
