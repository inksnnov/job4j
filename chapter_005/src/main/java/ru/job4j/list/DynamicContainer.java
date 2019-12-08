package ru.job4j.list;

import java.util.*;

/**
 * Примитивная реализация динамического контейнера(ArrayList).
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class DynamicContainer<E> implements Iterable<E> {

    /**
     * Контейнер.
     */
    private Object[] array;

    /**
     * Размер контейнера(считает только элементы).
     */
    private int size = 0;

    /**
     * Начальный размер контейнера по умолчанию, если не вызван конструктор
     * DynamicContainer(int capacity).
     */
    private final static int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор по умолчанию, устанавливает начальный размер контейнера 10 ячеек.
     */
    public DynamicContainer() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Конструктор позволяет задать размер контейнера.
     *
     * @param capacity int начальный размер контейнера.
     */
    public DynamicContainer(int capacity) {
        array = new Object[capacity];
    }

    /**
     * Добавляем элемент в контейнер, если места в контейнере закончились
     * создаем новый массив + 10 ячеек.
     *
     * @param e элемент.
     */
    public void add(E e) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + DEFAULT_CAPACITY);
        }
        array[size++] = e;
    }

    /**
     * Возвращаем элемент по индексу.
     *
     * @param index int index.
     * @return E элемент.
     * @throws IndexOutOfBoundsException кидаем исключение если индекс выходит за границы диапазона.
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    /**
     * Возвращаем размер контейнера.
     *
     * @return int размер.
     */
    public int size() {
        return size;
    }

    /**
     * Итератор для контейнера
     *
     * @return Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /**
             * Записываем состояние каретки контейнера для проверки изменений.
             */
            private final int snapshot = size;

            /**
             * Каретка итератора.
             */
            private int index = 0;

            /**
             * Проверяем возможен ли дальнейший ход.
             *
             * @return Вернем true если возможен, иначе false.
             */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /**
             * Возращаем следующий элемент.
             *
             * @return E элемент.
             * @throws NoSuchElementException бросим если элементов для возврата нет.
             * @throws ConcurrentModificationException кидаем если обнаружены изменения в контейнере,
             * смотрим по длинне записанной при создании объекта Iterator.
             */
            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (snapshot != size) {
                    throw new ConcurrentModificationException();
                }
                return (E) array[index++];
            }
        };
    }


}
