package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class CheckTest {

    @Test
    public void monoTestOne() {
        Check check = new Check();
        boolean[] input = {true, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void monoTestTwo() {
        Check check = new Check();
        boolean[] input = {true, true, true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}
