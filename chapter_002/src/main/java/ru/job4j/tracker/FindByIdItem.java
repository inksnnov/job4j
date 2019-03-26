package ru.job4j.tracker;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class FindByIdItem extends FormatOut implements UserAction {

    @Override
    public int key() {
        return 5;
    }

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

    @Override
    public String info() {
        return "5 - Поиск заявки по ID.";
    }
}
