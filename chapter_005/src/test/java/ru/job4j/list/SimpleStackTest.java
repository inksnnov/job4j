package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тесты к классу SimpleStack.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void load() {
        stack = new SimpleStack<>();
    }

    @Test
    public void stackTestOne() {
        for (int i = 0; i <= 50; i++) {
            stack.push(i);
        }
        for (int i = 50; i >= 0; i--) {
            assertThat(stack.pool(), is(i));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void stackTestTwo() {
        stack.pool();
    }
}