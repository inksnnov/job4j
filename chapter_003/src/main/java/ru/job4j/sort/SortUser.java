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

    /**
     * Метод сортирует коллекцию List по длинне имени.
     *
     * @param userList Список List.
     * @param <T>      Класс User или наследник.
     * @return Отсортированный List.
     */
    public <T extends User> List<T> sortNameLength(List<T> userList) {
        userList.sort(Comparator.comparingInt(o -> o.getName().length()));
        return userList;
    }

    /**
     * Метод сортирует коллекцию List по двум критериям, по имени,
     * если равны, то по возрасту.
     *
     * @param userList Список LIst.
     * @param <T>      Класс User или наследник.
     * @return Отсортированный List.
     */
    public <T extends User> List<T> sortByAllFields(List<T> userList) {
        userList.sort((o1, o2) -> {
            int result = o1.getName().compareToIgnoreCase(o2.getName());
            if (result == 0) {
                result = o1.getAge() - o2.getAge();
            }
            return result;
        });
        return userList;
    }
}
