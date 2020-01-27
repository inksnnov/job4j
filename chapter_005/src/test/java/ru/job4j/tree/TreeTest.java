package ru.job4j.tree;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тесты к классу Tree.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class TreeTest {
    @Test
    public void treeTestOne() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void treeTestTwo() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void treeTestTree() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(3, 5);
        Iterator<Integer> iterator = tree.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void treeTestFour() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        Iterator<Integer> iterator = tree.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(4));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(5));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(6));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(7));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void treeTestFive() {
        Tree<Integer> tree = new Tree<>(1);
        Iterator<Integer> iterator = tree.iterator();
        iterator.next();
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void treeTestSix() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        Iterator<Integer> iterator = tree.iterator();
        tree.add(1, 3);
        iterator.next();
    }

    @Test
    public void treeTestSeven() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertFalse(tree.add(1, 2));
    }

    @Test
    public void treeTestEight() {
        Tree<Integer> tree = new Tree<>(1);
        assertFalse(tree.add(2, 2));
    }
}
