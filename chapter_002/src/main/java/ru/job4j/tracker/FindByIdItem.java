package ru.job4j.tracker;

/**
 * Класс поиск заявки по ID.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class FindByIdItem extends FormatOut implements UserAction {

    /**
     * Ключ меню.
     *
     * @return int ключ.
     */
    @Override
    public int key() {
        return 5;
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

    /**
     * Показывает информация о действии этого класса в пункте меню.
     *
     * @return String действие.
     */
    @Override
    public String info() {
        return "5 - Поиск заявки по ID.";
    }
}
