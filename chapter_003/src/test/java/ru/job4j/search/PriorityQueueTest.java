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

    private PriorityQueue queue = new PriorityQueue();

    @Test
    public void whenHigherPriorityOne() {
        this.queue.put(new Task("low", 5));
        this.queue.put(new Task("urgent", 1));
        this.queue.put(new Task("middle", 3));
        assertThat(this.queue.take().getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriorityTwo() {
        this.queue.put(new Task("urgent", 1));
        this.queue.put(new Task("low", 5));
        this.queue.put(new Task("urgent", 1));
        this.queue.put(new Task("middle", 3));
        assertThat(this.queue.take().getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriorityThree() {
        this.queue.put(new Task("low", 5));
        this.queue.put(new Task("low", 5));
        this.queue.put(new Task("middle", 3));
        this.queue.put(new Task("urgent", 1));
        this.queue.take();
        assertThat(this.queue.take().getDesc(), is("middle"));
    }
}
