package ru.job4j.tracker;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ReplaceItem implements UserAction {

    @Override
    public int key() {
        return 1;
    }

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

    @Override
    public String info() {
        return "1 - Замена заявки.";
    }
}
