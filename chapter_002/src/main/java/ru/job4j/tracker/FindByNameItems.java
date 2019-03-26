package ru.job4j.tracker;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class FindByNameItems extends FormatOut implements UserAction {

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Поиск заявок по имени.");
        String name = input.ask("Введите имя заявки : ");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            super.format(item.getName(), item.getDesc());
        }
    }

    @Override
    public String info() {
        return "4 - Поиск заявок по имени.";
    }
}
