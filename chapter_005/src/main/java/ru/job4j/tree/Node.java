package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Элемент-хранилище узла дерева.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Node<E extends Comparable<E>> {
    /**
     * Ветки узла.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Значение узла.
     */
    private final E value;

    /**
     * Инициализируем значение при создании узла.
     *
     * @param value
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Добавляем ветку.
     *
     * @param child
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Возвращаем значение ноды.
     *
     * @return E значение.
     */
    public E getValue() {
        return value;
    }

    /**
     * Возвращаем ветки узла.
     *
     * @return List<Node < E>> ветки узла.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Сравниваем значение узла с входящим значением.
     *
     * @param that E входное значение.
     * @return true значение равны, иначе false.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }
}
