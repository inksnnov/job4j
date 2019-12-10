package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Частичная реализация LinkedList.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class LinkedContainer<E> implements Iterable<E> {
    /**
     * Ссылка на первый Node<E>.
     */
    private Node<E> first;
    /**
     * Указывает на последний элемент
     */
    private Node<E> last;
    /**
     * Размер контейнера.
     */
    private int size;

    /**
     * Добавляем элемент в контейнер, если размер нулевой пишем в first(первый элемент).
     *
     * @param value E элемент.
     */
    public void add(E value) {
        Node<E> newItem = new Node<>(value);
        if (size == 0) {
            first = newItem;
            last = first;
        } else {
            last.next = newItem;
            last = newItem;
        }
        size++;
    }

    /**
     * Получить значение по индексу, перебираем элементы в цикле.
     *
     * @param index int индекс элемента в цепочке.
     * @return E элемент.
     * @throws IndexOutOfBoundsException кидаем если индекс не попал в диапазон от 0 до size -1.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.element;
    }

    /**
     * Метод возвращает размер коллекции.
     *
     * @return int размер коллекции.
     */
    public int size() {
        return size;
    }

    /**
     * Реализация контейнера для односвязного списка.
     *
     * @param <E> тип хранимого элемента.
     */
    private static class Node<E> {
        /**
         * Сам элемент.
         */
        E element;
        /**
         * Ссылка на следующий элемент.
         */
        Node<E> next;

        /**
         * Конструктор по умолчанию.
         *
         * @param element сохраняем элемент в поле element.
         */
        public Node(E element) {
            this.element = element;
        }
    }

    /**
     * Итератор для односвязного списка.
     *
     * @return Iterator<E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * Инициализируем поле при создании итератора первым элементом.
             */
            private Node<E> item = first;
            /**
             * Фиксируем счетчик изменений.
             */
            private int expectModCount = size;

            /**
             * Каретка.
             */
            private int count = 0;

            /**
             * Проверяем есть ли возможность вернуть следующий элемент.
             *
             * @return есла да true, иначе false.
             */
            @Override
            public boolean hasNext() {
                return count < size;
            }

            /**
             * Возвращаем следующий элемент из коллекции.
             * @return E элемент
             * @throws NoSuchElementException кидаем в случае отсутствия
             * следующего элемента.
             * @throws ConcurrentModificationException кидаем если коллекция была изменена после
             * создания объекта итератора.
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectModCount != size) {
                    throw new ConcurrentModificationException();
                }
                Node<E> temp;
                temp = item;
                item = temp.next;
                count++;
                return temp.element;
            }
        };
    }
}
