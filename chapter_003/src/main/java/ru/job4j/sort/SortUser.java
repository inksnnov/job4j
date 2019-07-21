package ru.job4j.sort;

import java.util.*;

/**
 * Класс для работы с пользователями.
 */
public class SortUser {

    /**
     * Преобразуем список в множество, переопределенный метод compareTo сортирует
     * множество по возрасту.
     *
     * @param input список.
     * @return Set.
     */
    public <T extends Comparable> Set<T> sort(List<T> input) {
        return new TreeSet<>(input);
    }

}
