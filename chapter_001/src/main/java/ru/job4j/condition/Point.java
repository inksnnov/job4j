package ru.job4j.condition;

/**
 * Класс расчета расстояния между точками в системе координат.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 25.02.19.
 */
public class Point {

    /**
     * Ось x.
     */
    private int x;
    /**
     * Ось y.
     */
    private int y;

    /**
     * Принимает значения оси координат.
     *
     * @param x int ось x.
     * @param y int ось y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод вычисления координат.
     *
     * @param that Point
     * @return double расстояние между точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }
}
