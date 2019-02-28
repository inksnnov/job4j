package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class FactorialTest {

    @Test
    public void calcTestOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        int expect = 120;
        assertThat(result, is(expect));
    }

    @Test
    public void calcTestTwo() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(10);
        int expect = 3628800;
        assertThat(result, is(expect));
    }
}
