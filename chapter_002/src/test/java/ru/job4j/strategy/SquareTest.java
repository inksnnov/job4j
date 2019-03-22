package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SquareTest {

    @Test
    public void squareDrawTest() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                .append("+++++++")
                .append("+     +")
                .append("+     +")
                .append("+++++++")
                .toString()
        ));
    }
}
