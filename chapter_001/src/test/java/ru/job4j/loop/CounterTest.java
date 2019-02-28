package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class CounterTest {

    @Test
    public void addTestOne() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expect = 30;
        assertThat(result, is(expect));
    }

    @Test
    public void addTestTwo() {
        Counter counter = new Counter();
        int result = counter.add(4, 20);
        int expect = 108;
        assertThat(result, is(expect));
    }
}
