package ru.job4j.teststream;

import java.util.Comparator;

/**
 * Класс студент.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0
 */
public class Student implements Comparator<Student> {

    /**
     * Имя студента.
     */
    private String name;

    /**
     * Проходной балл
     */
    private int scope;

    /**
     * Дефолтный конструктор, для передачи в качестве аргумента(Comparator).
     */
    public Student() {
    }

    /**
     * Инициализируем поля.
     *
     * @param name имя студента.
     * @param scope балл.
     */
    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    /**
     * Получаем балл.
     * @return scope
     */
    public int getScope() {
        return scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o2.scope - o1.scope;
    }
}
