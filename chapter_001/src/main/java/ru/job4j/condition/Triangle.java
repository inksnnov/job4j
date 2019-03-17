package ru.job4j.condition;

/**
 * Вычисление площади треугольника.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 27.02.19.
 */
public class Triangle {

    private Point pointOne;
    private Point pointTwo;
    private Point pointThree;

    public Triangle(Point a, Point b, Point c) {
        this.pointOne = a;
        this.pointTwo = b;
        this.pointThree = c;
    }

    /**
     * Метод вычисляет полупериметр по длиннам сторон треугольника.
     *
     * @param a double Сторона a.
     * @param b double Сторона b.
     * @param c double Сторона c.
     * @return double полупериметр.
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * Метод вычисляет площадь треугольника.
     *
     * @return double площадь треугольника.
     */
    public double area() {
        double result = -1;
        double a = pointOne.distanceTo(pointTwo);
        double b = pointTwo.distanceTo(pointThree);
        double c = pointOne.distanceTo(pointThree);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return result;
    }

    /**
     * Метод вычисляет возможность существования треугольника когда
     * сумма любых его двух сторон больше третьей стороны.
     *
     * @param a double сторона a.
     * @param b double сторона b.
     * @param c double сторона c.
     * @return boolean если треугольник существует возвращает true.
     */
    private boolean exist(double a, double b, double c) {
        boolean result = false;
        if (a + b > c && a + c > b && b + c > a) {
            result = true;
        }
        return result;
    }
}
