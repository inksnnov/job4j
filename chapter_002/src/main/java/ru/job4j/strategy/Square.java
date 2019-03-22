package ru.job4j.strategy;

/**
 * Класс реализует фигуру в виде квадрата.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Square implements Shape {

    /**
     * Метод возвращает фигуру типа квадрат.
     *
     * @return String квадрат.
     */
    @Override
    public String draw() {
        StringBuilder square = new StringBuilder();
        square.append("+++++++");
        square.append("+     +");
        square.append("+     +");
        square.append("+++++++");
        return square.toString();
    }
}
