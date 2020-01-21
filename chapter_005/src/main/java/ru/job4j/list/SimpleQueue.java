package ru.job4j.list;

/**
 * Реализация очереди на двух стеках
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SimpleQueue<T> {
    /**
     * Входной стек.
     */
    private SimpleStack<T> input;
    /**
     * Выходной стек.
     */
    private SimpleStack<T> output;

    /**
     * Инициализируем стеки.
     */
    public SimpleQueue() {
        this.input = new SimpleStack<>();
        this.output = new SimpleStack<>();
    }

    /**
     * Если выходной стек пуст, перемещаем элементы
     * в него из входного и отдаем элементы по одному.
     *
     * @return T элемент.
     */
    public T pool() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pool());
            }
        }
        return output.pool();
    }

    /**
     * Помещаем элемент во входной стек.
     *
     * @param value T элемент.
     */
    public void push(T value) {
        input.push(value);
    }
}
