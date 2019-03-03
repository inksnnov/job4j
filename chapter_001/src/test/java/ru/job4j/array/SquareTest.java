package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 03.03.19.
 */
public class SquareTest {

    @Test
    public void calculateTestOne() {
        Square square = new Square();
        int[] result = square.calculate(3);
        int[] expect = {1, 4, 9};
        assertArrayEquals(result, expect);
    }

    @Test
    public void calculateTestTwo() {
        Square square = new Square();
        int[] result = square.calculate(8);
        int[] expect = {1, 4, 9, 16, 25, 36, 49, 64};
        assertArrayEquals(result, expect);
    }

}
