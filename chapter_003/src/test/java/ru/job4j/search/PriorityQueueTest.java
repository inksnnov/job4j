package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты к классу заданию очередь с приоритетом.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class PriorityQueueTest {

    @Test
    public void whenHigherPriorityOne() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        assertThat(queue.take().getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriorityTwo() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        assertThat(queue.take().getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriorityThree() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("low", 5));
        queue.put(new Task("middle", 3));
        queue.put(new Task("urgent", 1));
        queue.take();
        assertThat(queue.take().getDesc(), is("middle"));
    }
}
