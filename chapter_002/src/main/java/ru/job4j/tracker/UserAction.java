package ru.job4j.tracker;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker);

    String info();

}
