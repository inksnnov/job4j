package ru.job4j.tracker;

/**
 * Класс для работы с пользователем программы Tracker.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 18.03.19.
 */
public class StartUI {

    /**
     * Константа меню - добавление новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню - редактирование существующей заявки.
     */
    private static final String REPLACE = "1";

    /**
     * Константа меню - удаление существующей заявки.
     */
    private static final String DELETE = "2";

    /**
     * Константа меню - показать все заявки.
     */
    private static final String SHOWALL = "3";

    /**
     * Константа меню - найти заявки по имени.
     */
    private static final String FINDBYNAME = "4";

    /**
     * Константа меню - поиск заявки по Id.
     */
    private static final String FINDBYID = "5";

    /**
     * Константа меню - выход из программы.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранильще и обработка заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     *
     * @param input   получение данных от  пользователя.
     * @param tracker хранение и обработка заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной метод программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answert = this.input.ask("Введите пункт меню :");
            if (ADD.equals(answert)) {
                this.createItem();
            } else if (REPLACE.equals(answert)) {
                this.replaceItem();
            } else if (DELETE.equals(answert)) {
                this.deleteItem();
            } else if (SHOWALL.equals(answert)) {
                this.showAllItems();
            } else if (FINDBYNAME.equals(answert)) {
                this.findByNameItems();
            } else if (FINDBYID.equals(answert)) {
                this.findByIdItems();
            } else if (EXIT.equals(answert)) {
                exit = true;
            }
        }
    }

    /**
     * Метод создания заявки.
     */
    private void createItem() {
        System.out.println("------------Добавление новой заявки------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, this.setTime());
        this.tracker.add(item);
        System.out.println("Заявка успешно добавлена.");
    }

    /**
     * Метод редактирования заявки.
     */
    private void replaceItem() {
        System.out.println("-------------Редактирование заявки------------");
        String id = this.input.ask("Введите ID редактируемой заявки :");
        if (this.tracker.findById(id) != null) {
            String name = this.input.ask("Введите новое имя заявки.");
            String desc = this.input.ask("Введите новое описание к заявке.");
            Item item = new Item(name, desc, this.setTime());
            if (this.tracker.replace(id, item)) {
                System.out.println("Заявка успешно отредактирована.");
            } else {
                System.out.println("Заявка не отредактирована, попробуйте снова.");
            }
        } else {
            System.out.println("Введен неверный ID.");
        }
    }

    /**
     * Метод удаления заявки.
     */
    private void deleteItem() {
        System.out.println("------------Удаление заявки------------");
        String id = this.input.ask("Введите ID удаляемой заявки.");
        if (this.tracker.findById(id) != null) {
            if (this.tracker.delete(id)) {
                System.out.println("Заявка удалена.");
            } else {
                System.out.println("Заявка не удалена, попробуйте снова.");
            }
        } else {
            System.out.println("Введен неверный ID.");
        }
    }

    /**
     * Метод выводит все сохраненные заявки.
     */
    private void showAllItems() {
        System.out.println("------------Все заявки------------");
        Item[] items = this.tracker.findAll();
        for (Item item : items) {
            this.formatOut(item.getName(), item.getDesc());
        }
    }

    /**
     * Поиск заявок по имени- выводит все заявки с одним именем.
     */
    private void findByNameItems() {
        System.out.println("Поиск заявок по имени.");
        String name = this.input.ask("Введите имя заявки : ");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            this.formatOut(item.getName(), item.getDesc());
        }
    }

    /**
     * Поиск заявки по Id.
     */
    private void findByIdItems() {
        System.out.println("Поиск заявки по ID");
        String id = this.input.ask("Введите номер заявки");
        Item item = this.tracker.findById(id);
        if (item != null) {
            this.formatOut(item.getName(), item.getDesc());
        }
    }

    /**
     * Пользовательское меню.
     */
    private void showMenu() {
        System.out.println("Меню");
        System.out.println("0 - Добавление заявки.");
        System.out.println("1 - Замена заявки.");
        System.out.println("2 - Удаление заявки.");
        System.out.println("3 - Показать все заявки.");
        System.out.println("4 - Поиск заявки по имени.");
        System.out.println("5 - Поиск заявки по Id.");
        System.out.println("6 - Выход из программы.");
    }

    /**
     * Метод возвращает время в миллисекундах.
     *
     * @return long время в мс.
     */
    private long setTime() {
        return System.currentTimeMillis();
    }

    /**
     * Вывод в консоль имени и описания заявки в форматированном виде.
     *
     * @param name item.getName().
     * @param desc item.getDesc().
     */
    private void formatOut(String name, String desc) {
        String ln = System.lineSeparator();
        System.out.printf("%s %s %s", "Имя заявки : ", name, ln);
        System.out.printf("%s %s %s %s %s", "Описание заявки :", ln, desc, ln, ln);
    }

    /**
     * Точка входа в программу.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
