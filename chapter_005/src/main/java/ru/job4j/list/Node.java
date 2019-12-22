package ru.job4j.list;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}