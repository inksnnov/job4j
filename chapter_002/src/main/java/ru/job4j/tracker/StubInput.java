package ru.job4j.tracker;

/**
 * Реализация интерфейса {@link UserAction}, для иммитации ввода с консоли.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class StubInput implements Input {

    private final String[] value;

    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}
