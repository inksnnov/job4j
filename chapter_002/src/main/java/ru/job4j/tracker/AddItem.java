package ru.job4j.tracker;

/**
 * Класс добавления заявки.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class AddItem implements UserAction {


    /**
     * Ключ меню.
     *
     * @return int ключ.
     */
    @Override
    public int key() {
        return 0;
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

    /**
     * Показывает информация о действии этого класса в пункте меню.
     *
     * @return String действие.
     */
    @Override
    public String info() {
        return "0 - Добавление заявки.";
    }
}
