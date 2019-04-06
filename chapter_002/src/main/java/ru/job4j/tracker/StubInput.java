package ru.job4j.tracker;

/**
 * Реализация интерфейса {@link Input}, для иммитации ввода с консоли.
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

    @Override
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Некорректный пункт меню, повторите ввод.");
        }
    }
}
