package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

/**
 * Класс для работы с пользователем программы Tracker.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранильще и обработка заявок.
     */
    private final Tracker tracker;

    /**
     * Поле выхода из программы в методе {@link StartUI#init()}.
     */
    private boolean exitStatus = true;

    private final Consumer<String> output;

    /**
     * Конструктор инициализирующий поля.
     *
     * @param input   {@link StartUI#input}.
     * @param tracker {@link StartUI#tracker}.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основной метод.
     * Показывает пользователю меню и запрашивает действие.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions(this);
        List<Integer> ranges = menu.getMenuRange();
        do {
            menu.show();
            menu.select(input.ask("select:", ranges));
        } while (exitStatus);
    }

    /**
     * Смена состояния поля {@link StartUI#exitStatus} для выхода из программы.
     */
    public void exit() {
        this.exitStatus = false;
    }

    /**
     * Запускаем программу.
     *
     * @param args не используем.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
