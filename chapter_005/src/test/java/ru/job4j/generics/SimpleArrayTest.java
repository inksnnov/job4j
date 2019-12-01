package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Тесты к классу SimpleArray.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SimpleArrayTest {

    private SimpleArray<Integer> array;

    @Before
    public void load() {
        array = new SimpleArray<>(10);
    }

    @Test
    public void addToSimpleArrayTestOne() {
        array.add(1);
        assertThat(array.get(0), is(1));
    }

    @Test
    public void addToSimpleArrayTestTwo() {
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        assertThat(array.get(0), is(0));
        assertThat(array.get(1), is(1));
        assertThat(array.get(2), is(2));
        assertThat(array.get(3), is(3));
        assertThat(array.get(4), is(4));
        assertThat(array.get(5), is(5));
        assertThat(array.get(6), is(6));
        assertThat(array.get(7), is(7));
        assertThat(array.get(8), is(8));
        assertThat(array.get(9), is(9));
    }

    @Test(expected = ArrayStoreException.class)
    public void addToSimpleArrayTestThree() {
        for (int i = 0; i < 11; i++) {
            array.add(i);
        }
    }

    @Test
    public void setInSimpleArrayTestOne() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        assertThat(array.set(0, 22), is(0));
        assertThat(array.get(0), is(22));
    }

    @Test
    public void setInSimpleArrayTestTwo() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        assertThat(array.set(4, 22), is(4));
        assertThat(array.get(4), is(22));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setInSimpleArrayTestThree() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.set(5, 22);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setInSimpleArrayTestFour() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.set(-1, 22);
    }

    @Test
    public void getElementFromSimpleArrayTestOne() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        assertThat(array.get(0), is(0));
        assertThat(array.get(1), is(1));
        assertThat(array.get(2), is(2));
        assertThat(array.get(3), is(3));
        assertThat(array.get(4), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void getElementFromSimpleArrayTestTwo() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.get(-1);
    }

    @Test(expected = NoSuchElementException.class)
    public void getElementFromSimpleArrayTestThree() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.get(5);
    }

    @Test
    public void removeElementFromSimpleArrayTestOne() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.remove(0);
        assertThat(array.get(0), is(1));
        assertThat(array.get(1), is(2));
        assertThat(array.get(2), is(3));
        assertThat(array.get(3), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void removeElementFromSimpleArrayTestTwo() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.remove(4);
        assertThat(array.get(0), is(0));
        assertThat(array.get(1), is(1));
        assertThat(array.get(2), is(2));
        assertThat(array.get(3), is(3));
        assertThat(array.get(4), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeElementFromSimpleArrayTestThree() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.remove(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void removeElementFromSimpleArrayTestFour() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        array.remove(5);
    }

    @Test
    public void iteratorTestOne() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        Iterator iterator = array.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorTestTwo() {
        for (int i = 0; i < 5; i++) {
            array.add(i);
        }
        Iterator iterator = array.iterator();
        for (int i = 0; i < 6; i++) {
            iterator.next();
        }
    }
}
