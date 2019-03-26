package ru.job4j.tracker;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ShowAllItem extends FormatOut implements UserAction {

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------Все заявки------------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            super.format(item.getName(), item.getDesc());
        }
    }

    @Override
    public String info() {
        return "3 - Показать все заявки.";
    }
}
