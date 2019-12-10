package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тесты к классу LinkedContainer.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class LinkedContainerTest {
    private LinkedContainer<Integer> container;

    @Before
    public void load() {
        container = new LinkedContainer<>();
        for (int i = 0; i < 10; i++) {
            container.add(i);
        }
    }

    @Test
    public void containerTestOne() {
        assertThat(container.get(0), is(0));
        assertThat(container.get(1), is(1));
        assertThat(container.get(2), is(2));
        assertThat(container.get(3), is(3));
        assertThat(container.get(4), is(4));
        assertThat(container.get(5), is(5));
        assertThat(container.get(6), is(6));
        assertThat(container.get(7), is(7));
        assertThat(container.get(8), is(8));
        assertThat(container.get(9), is(9));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void containerTestTwo() {
        assertThat(container.get(0), is(0));
        assertThat(container.get(1), is(1));
        assertThat(container.get(2), is(2));
        assertThat(container.get(3), is(3));
        assertThat(container.get(4), is(4));
        assertThat(container.get(5), is(5));
        assertThat(container.get(6), is(6));
        assertThat(container.get(7), is(7));
        assertThat(container.get(8), is(8));
        assertThat(container.get(9), is(9));
        assertThat(container.get(10), is(10));
    }

    @Test
    public void containerTestThree() {
        Iterator<Integer> iterator = container.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(0));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(6));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(8));
        assertThat(iterator.next(), is(9));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void containerTestFour() {
        Iterator<Integer> iterator = container.iterator();
        for (int i = 0; i < 11; i++) {
            iterator.next();
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void containerTestFive() {
        Iterator<Integer> iterator = container.iterator();
        for (int i = 0; i < 11; i++) {
            if (i == 5) {
                container.add(12);
            }
            iterator.next();
        }
    }
}
