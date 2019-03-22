package ru.job4j.strategy;

/**
 * Класс реализует фигуру типа треугольник.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Triangle implements Shape {

    /**
     * Метод возвращает фигуру треугольник в виде строки.
     *
     * @return String треугольник.
     */
    @Override
    public String draw() {
        StringBuilder triangle = new StringBuilder();
        triangle.append("   +   ");
        triangle.append("  +++  ");
        triangle.append(" +++++ ");
        triangle.append("+++++++");
        return triangle.toString();
    }
}
