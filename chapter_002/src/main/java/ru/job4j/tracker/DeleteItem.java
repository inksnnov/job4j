package ru.job4j.tracker;

/**
 * Класс удаления заявки.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class DeleteItem extends BaseAction {

    /**
     * Конструктор инициализирует поля key и name.
     *
     * @param key  номер пункта меню.
     * @param name Описание пункта меню для вывода в консоль.
     */
    public DeleteItem(int key, String name) {
        super(key, name);
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
}
