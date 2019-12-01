package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Частичная реализация массива как коллекции(размер фиксированный).
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SimpleArray<T> implements Iterable<T> {

    /**
     * Хранима массив типа Object.
     */
    private Object[] values;

    /**
     * Каретка.
     */
    private int step = 0;

    /**
     * Создаем массив с передачей длинны в аргументах конструктора.
     *
     * @param size длинна массива values.
     */
    public SimpleArray(int size) {
        values = new Object[size];
    }

    /**
     * Добавляем элемент в массив, предвигая каретку +1.
     *
     * @param model T элемент.
     * @throws ArrayStoreException кидаем исключние если кончились ячейки в массиве для записи.
     */
    public void add(T model) {
        if (step > values.length - 1) {
            throw new ArrayStoreException("Array is full");
        }
        values[step++] = model;
    }

    /**
     * Метод заменяет существующий элемент, новым(T model).
     * При замене возвращает старый элемент.
     *
     * @param index индекс заменяемого элемента.
     * @param model новый элемент.
     * @return заменяемый элемент.
     * @throws ArrayIndexOutOfBoundsException кидаем исключение если вышли за границы существующих элементов.
     */
    @SuppressWarnings("unchecked")
    public T set(int index, T model) {
        if (index < 0 || index >= step) {
            throw new ArrayIndexOutOfBoundsException("Enter correct index" + 0 + " to " + values.length);
        }
        Object temp = values[index];
        values[index] = model;
        return (T) temp;
    }

    /**
     * Метод возвращает элемент по индексу.
     *
     * @param index индекс в массиве.
     * @return T элемент.
     * @throws NoSuchElementException кидаем исключение если вышли за границы существующих элементов.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= step) {
            throw new NoSuchElementException("Enter correct index" + 0 + " to " + step);
        }
        return (T) values[index];
    }

    /**
     * Метод удаляет элемент в массиве, сдвигая удаленную ячейку влево и перемещая каретку влево.
     *
     * @param index индекс удаляемого элемента.
     * @return Удаляемый элемент.
     * @throws ArrayIndexOutOfBoundsException кидаем исключение если вышли за границы существующих элементов.
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= step) {
            throw new ArrayIndexOutOfBoundsException("Enter correct index" + 0 + " to " + step);
        }
        T temp = (T) values[index];
        if (index == step - 1) {
            step--;
        } else {
            System.arraycopy(values, index + 1, values, index, values.length - 1 - index);
            step--;
        }
        return temp;
    }

    /**
     * Реализация итератора для одномерного массива.
     *
     * @return iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            /**
             * Каретка.
             */
            private int idx = 0;

            /**
             * Проверяет возможно ли вернуть следующий элемент,
             * границей справа являеться каретка step.
             *
             * @return boolean true если элемент справа имееться, иначе  false.
             */
            @Override
            public boolean hasNext() {
                return idx < step;
            }

            /**
             * Возвращает следующий элемент из массива, передвигая каретку idx.
             *
             * @return T элмент массива.
             * @throws NoSuchElementException кидаем исключение если элемента для возврата нет.
             */
            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) values[idx++];
            }
        };
    }
}
