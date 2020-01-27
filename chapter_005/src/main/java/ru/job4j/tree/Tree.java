package ru.job4j.tree;

import java.util.*;

/**
 * Реализация простейшего дерева.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Корневой узел.
     */
    private Node<E> root;
    /**
     * Количество элементов в дереве.
     */
    private int size;

    /**
     * Инициализируем корень при создании дерева.
     *
     * @param value Значение корня.
     */
    public Tree(E value) {
        root = new Node<>(value);
    }

    /**
     * Добавление элемента в дерево, если в ветка узла если такой же
     * элемент добавления не происходит, если указан неверный parent
     * добавления не происходит.
     *
     * @param parent parent. Узел в который добавляем новую ветку.
     * @param child  child. Добавляемая ветка.
     * @return true - ветка добавлена, иначе false.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> value = findBy(parent);
        if (value.isPresent() && value.get().leaves().stream().noneMatch(x -> x.eqValue(child))) {
            result = true;
            size++;
            value.get().add(new Node<>(child));
        }
        return result;
    }

    /**
     * Поиск по дереву в ширину.
     *
     * @param value E значение.
     * @return Optional<Node < E>> искомый узел.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Реализация итератора для дерева основанная
     * на поиске элементов в ширину.
     *
     * @return Iterator<E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            /**
             * Счетчик изменений в дереве.
             */
            private int modCount = size;
            /**
             * Очередь из которой забираем элементы.
             */
            private Queue<Node<E>> data = new LinkedList<>();
            /**
             * Переменная для начальной инициализации очереди.
             */
            private boolean loadData;
            /**
             * Переменная служит для проверки вызова
             * метода next, только после вызова цикл в
             * hasNext продолжает заполение очереди из дочерних узлов.
             */
            boolean step;
            /**
             * Промежуточная переменная для обмена нодами между
             * методами next и hasNext.
             */
            Node<E> value;

            /**
             * Проверяем есть ли возможность следующего хода,
             * изначально при вызове инициализирует очередь корневой нодой,
             * если далее мы не вызываем next, очередь не заполняеться
             *
             * @return true элементы далее есть, иначе false.
             * @throws ConcurrentModificationException кидаем если дерево измененено.
             */
            @Override
            public boolean hasNext() {
                if (modCount != size) {
                    throw new ConcurrentModificationException();
                }
                if (!loadData) {
                    data.offer(root);
                    loadData = true;
                }
                if (step) {
                    step = false;
                    if (value != null) {
                        for (Node<E> child : value.leaves()) {
                            data.offer(child);
                        }
                    }
                }
                return !data.isEmpty();
            }

            /**
             * Отдаем следующий элемент из дерева.
             * step = true - hasNext методу можно собирать
             * дочерние узлы в очередь.
             * value = data.peek() берем узел из очереди и
             * в цикле добавляем его дочерние узлы в очередь.
             *
             * @return E элемент.
             * @throws NoSuchElementException кидаем если элементов не осталось.
             * @throws NullPointerException кидаем если пытаемся вернуть null.
             */
            @Override
            public E next() {
                step = true;
                value = data.peek();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return Objects.requireNonNull(data.poll()).getValue();
            }
        };
    }
}
