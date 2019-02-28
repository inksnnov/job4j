package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class BoardTest {

    @Test
    public void paintTest3x3() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String ln = System.lineSeparator();
        assertThat(result, is(
                String.format("X X%s X %sX X%s", ln, ln, ln)));
    }

    @Test
    public void paintTest5x5() {
        Board board = new Board();
        String result = board.paint(5, 5);
        String ln = System.lineSeparator();
        assertThat(result, is(
                String.format("X X X%s X X %sX X X%s X X %sX X X%s", ln, ln, ln, ln, ln)));
    }
}
