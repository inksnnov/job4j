package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 25.02.19.
 */
public class PointTest {
    @Test
    public void pointTestOne() {
        Point pointA = new Point(1, 4);
        Point pointB = new Point(2, 2);
        double expect = 2.23606797749979;
        assertThat(pointA.distanceTo(pointB), closeTo(expect, 0));
    }

}
