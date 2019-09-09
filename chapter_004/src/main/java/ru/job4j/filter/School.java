package ru.job4j.filter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс сортировки студентов по проходным баллам.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class School {

    /**
     * Метод сортирует студентов по Predicate переданному в аргументе this методу.
     *
     * @param students  Список студентов.
     * @param predicate Лямбда выражение - как мы хотим сортировать студентов.
     * @return Отсортированный список студентов.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
