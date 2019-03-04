package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class FindLoopTest {

    @Test
    public void indexOftestOne() {
        FindLoop findLoop = new FindLoop();
        int[] input = {2, 4, 6, 1, 9, 5};
        int value = 4;
        int expect = 1;
        int result = findLoop.indexOf(input, value);
        assertThat(result, is(expect));
    }

    @Test
    public void indexOftestTwo() {
        FindLoop findLoop = new FindLoop();
        int[] input = {2, 4, 6, 1, 9, 5, 1};
        int value = 7;
        int expect = -1;
        int result = findLoop.indexOf(input, value);
        assertThat(result, is(expect));
    }
}
