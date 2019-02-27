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
        Triangle triangle = new Triangle();
        double result = triangle.area(0, 0, 0, 2, 2, 0);
        double expect = 2D;
        assertThat(result, closeTo(expect, 0.1));
    }

    @Test
    public void triTestTwo() {
        Triangle triangle = new Triangle();
        double result = triangle.area(2, 2, 2, 2, 2, 2);
        assertThat(result, closeTo(-1, 0));
    }

    @Test
    public void triTestThree() {
        Triangle triangle = new Triangle();
        double result = triangle.area(0, 0, 2, 2, 2, 2);
        assertThat(result, closeTo(0, 0));
    }
}
