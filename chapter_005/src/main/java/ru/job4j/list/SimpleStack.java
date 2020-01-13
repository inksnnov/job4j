package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * Реализация простейшего стека на связанном списке.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SimpleStack<T> {
    /**
     * Храним стек в односвязном списке.
     */
    private LinkedContainer<T> container;
    /**
     * Размер списка.
     */
    private int size;

    /**
     * Создаем объект односвязного списка.
     */
    public SimpleStack() {
        container = new LinkedContainer<>();
    }

    /**
     * Метод возвращает последний элемент в списке,
     * удаляя его из очереди(size - 1).
     *
     * @return T элемент.
     * @throws NoSuchElementException кидаем если список пуст.
     */
    public T pool() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return container.get(--size);
    }

    /**
     * Помещаем эемент в спискок.
     * Прибавляем размер на + 1.
     *
     * @param value T элемент.
     */
    public void push(T value) {
        container.add(value);
        size++;
    }

    /**
     * ПУстая ли коллекция?
     *
     * @return true если пустая, иначе false.
     */
    boolean isEmpty() {
        return size == 0;
    }
}
