package ru.job4j.teststream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс для сортировки и выборки студентов по баллу.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class StudentScopeCompare {

    /**
     * Метод сортирует студентов по баллу, отсеивая null элементы в списке,
     * сортировка по убыванию.
     * Далеее по условию забираем из списка все элементы до int bound,
     * возвращаем List.
     *
     * @param students Список студентов.
     * @param bound    по какому баллу будем отбирать студентов.
     * @return Отобранный список студетнов.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(new Student())
                .takeWhile(x -> x.getScope() >= bound)
                .collect(Collectors.toList());
    }
}
