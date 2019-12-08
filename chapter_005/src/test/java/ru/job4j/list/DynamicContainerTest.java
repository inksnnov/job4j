package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тесты к классу DynamicContainer.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class DynamicContainerTest {

    private DynamicContainer<Integer> container;

    @Before
    public void load() {
        container = new DynamicContainer<>();
        container.add(0);
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
        container.add(5);
        container.add(6);
        container.add(7);
        container.add(8);
        container.add(9);
        container.add(10);
        container.add(11);
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
        assertThat(container.get(10), is(10));
        assertThat(container.get(11), is(11));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void containerTestTwo() {
        container.get(13);
    }

    @Test
    public void containerTestThree() {
        assertThat(container.size(), is(12));
    }

    @Test
    public void iteratorTestOne() {
        Iterator<Integer> iterator = container.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorTestTwo() {
        Iterator<Integer> iterator = container.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorTestThree() {
        Iterator<Integer> iterator = container.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        container.add(1);
        assertTrue(iterator.hasNext());
        iterator.next();

    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorTestFour() {
        Iterator<Integer> iterator = container.iterator();
        container.add(1);
        assertTrue(iterator.hasNext());
        iterator.next();
    }


}
