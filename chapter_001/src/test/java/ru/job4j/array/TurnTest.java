package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class TurnTest {

    @Test
    public void backTestOne() {
        Turn turn = new Turn();
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int[] result = turn.back(input);
        int[] expect = {7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(result, expect);
    }

    @Test
    public void backTestTwo() {
        Turn turn = new Turn();
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] result = turn.back(input);
        int[] expect = {6, 5, 4, 3, 2, 1};
        assertArrayEquals(result, expect);
    }
}
