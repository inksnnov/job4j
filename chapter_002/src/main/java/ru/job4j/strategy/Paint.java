package ru.job4j.strategy;

/**
 * Класс для вывода в консоль геометрических фигур.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Paint {

    /**
     * Поле хранит фигуру.
     */
    private Shape shape;

    /**
     * Инициализирует поле shape.
     *
     * @param shape Shape фигура.
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * Вывод фигуры на консоль.
     */
    public void toConsoleOut() {
        System.out.println(this.shape.draw());
    }
}
