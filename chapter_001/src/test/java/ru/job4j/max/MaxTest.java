package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 26.02.19.
 */
public class MaxTest {

    @Test
    public void maxTestOne() {
        Max maximal = new Max();
        int result = maximal.max(4, 12);
        assertThat(result, is(12));
    }

    @Test
    public void maxTestTwo() {
        Max maximal = new Max();
        int result = maximal.max(7, 2);
        assertThat(result, is(7));
    }
}
