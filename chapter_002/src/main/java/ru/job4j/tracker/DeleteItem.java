package ru.job4j.tracker;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class DeleteItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

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

    @Override
    public String info() {
        return "2 - Удаление заявки.";
    }
}
