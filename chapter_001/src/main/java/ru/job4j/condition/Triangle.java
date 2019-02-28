package ru.job4j.condition;

/**
 * Вычисление площади треугольника.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 27.02.19.
 */
public class Triangle {

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
     * @param x1 int координата точки a оси x.
     * @param y1 int координата точки a оси y.
     * @param x2 int координата точки b оси x.
     * @param y2 int координата точки b оси y.
     * @param x3 int координата точки c оси x.
     * @param y3 int координата точки c оси y.
     * @return double площадь треугольника.
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double result = -1;
        Point pointOne = new Point(x1, y1);
        Point pointTwo = new Point(x2, y2);
        Point pointThree = new Point(x3, y3);
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
