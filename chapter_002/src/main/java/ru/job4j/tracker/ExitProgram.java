package ru.job4j.tracker;

/**
 * Реализация класса выхода из программы.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ExitProgram implements UserAction {

    /**
     * Поле объекта {@link StartUI} для вызова метода {@link StartUI#exit()}.
     */
    private final StartUI ui;

    /**
     * Конструктор инициализации поля {@link ExitProgram#ui}.
     *
     * @param ui
     */
    public ExitProgram(StartUI ui) {
        this.ui = ui;
    }

    /**
     * Ключ меню.
     *
     * @return int ключ.
     */
    @Override
    public int key() {
        return 6;
    }

    /**
     * Выход из программы.
     * @param input {@link Input}.
     * @param tracker {@link Tracker}.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.exit();
    }

    /**
     * Показывает информация о действии этого класса в пункте меню.
     *
     * @return String действие.
     */
    @Override
    public String info() {
        return "6 - Выход из программы.";
    }
}
