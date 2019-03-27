package ru.job4j.tracker;

/**
 * Класс - редактирование заявки.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ReplaceItem implements UserAction {

    /**
     * Ключ меню.
     *
     * @return int ключ.
     */
    @Override
    public int key() {
        return 1;
    }

    /**
     * Реализация редактирование существующей заявки.
     *
     * @param input   {@link Input}.
     * @param tracker {@link Tracker}
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("-------------Редактирование заявки------------");
        String id = input.ask("Введите ID редактируемой заявки :");
        String name = input.ask("Введите новое имя заявки.");
        String desc = input.ask("Введите новое описание к заявке.");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешно отредактирована.");
        } else {
            System.out.println("Заявка не отредактирована, попробуйте снова.");
        }
    }

    /**
     * Показывает информация о действии этого класса в пункте меню.
     *
     * @return String действие.
     */
    @Override
    public String info() {
        return "1 - Замена заявки.";
    }
}
