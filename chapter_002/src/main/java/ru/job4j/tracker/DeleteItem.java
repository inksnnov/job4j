package ru.job4j.tracker;

/**
 * Класс удаления заявки.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class DeleteItem implements UserAction {

    /**
     * Ключ меню.
     *
     * @return int ключ.
     */
    @Override
    public int key() {
        return 2;
    }

    /**
     * Реализация удаления заявки.
     *
     * @param input   {@link Input}.
     * @param tracker {@link Tracker}
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Удаление заявки------------");
        String id = input.ask("Введите ID удаляемой заявки.");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена.");
        } else {
            System.out.println("Заявка не удалена, попробуйте снова.");
        }
    }

    /**
     * Показывает информация о действии этого класса в пункте меню.
     *
     * @return String действие.
     */
    @Override
    public String info() {
        return "2 - Удаление заявки.";
    }
}
