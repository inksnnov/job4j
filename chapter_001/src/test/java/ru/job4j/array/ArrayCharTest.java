package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class ArrayCharTest {

    @Test
    public void startWithTestOne() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void startWithTestTwo() {
        ArrayChar word = new ArrayChar("Index");
        boolean result = word.startWith("Hel");
        assertThat(result, is(false));
    }
}
