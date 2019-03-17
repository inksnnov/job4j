package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 27.02.19.
 */
public class TriangleTest {

    @Test
    public void triTestOne() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 2);
        Point pointC = new Point(2, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        double result = triangle.area();
        double expect = 2D;
        assertThat(result, closeTo(expect, 0.1));
    }

    @Test
    public void triTestTwo() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(0, 0);
        Point pointC = new Point(0, 0);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        double result = triangle.area();
        double expect = -1D;
        assertThat(result, closeTo(expect, 0));
    }

    @Test
    public void triTestThree() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(2, 2);
        Point pointC = new Point(2, 2);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        double result = triangle.area();
        double expect = -1D;
        assertThat(result, closeTo(expect, 0));
    }
}
