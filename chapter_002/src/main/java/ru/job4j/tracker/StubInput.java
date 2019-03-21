package ru.job4j.tracker;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 19.03.19.
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
