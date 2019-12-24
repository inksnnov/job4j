package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SimpleSetTest {

    private SimpleSet<Integer> set;

    @Before
    public void load() {
        set = new SimpleSet<>();
    }

    @Test
    public void simpleSetTestOne() {
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertTrue(set.add(4));
        assertFalse(set.add(2));
    }

    @Test
    public void simpleSetTestTwo() {
        assertTrue(set.add(1));
        assertFalse(set.add(1));
        assertFalse(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
        assertTrue(set.add(4));

    }

    @Test
    public void simpleSetTestThree() {
        assertTrue(set.add(null));
        assertFalse(set.add(null));
        assertTrue(set.add(3));
        assertTrue(set.add(4));

    }

}