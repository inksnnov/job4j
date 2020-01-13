package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Тесты к классу SimpleQueue.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SimpleQueueTest {
    private SimpleQueue<Integer> queue;

    @Before
    public void load() {
        queue = new SimpleQueue<>();
    }

    @Test
    public void queueTestOne() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.pool(), is(1));
        assertThat(queue.pool(), is(2));
        assertThat(queue.pool(), is(3));
    }

    @Test
    public void queueTestTwo() {
        for (int i = 0; i <= 50; i++) {
            queue.push(i);
        }
        for (int i = 0; i <= 50; i++) {
            assertThat(queue.pool(), is(i));
        }
    }

}