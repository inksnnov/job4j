package ru.job4j.tree;

import java.util.Optional;

/**
 * Интерфейс простого дерева.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    boolean add(E parent, E child);

    /**
     * Ищем имееться ли значение в дереве.
     *
     * @param value E значение.
     * @return Optional<Node < E>> искомый узел.
     */
    Optional<Node<E>> findBy(E value);
}