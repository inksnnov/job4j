package ru.job4j.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class PaintTest {

    @Test
    public void toConsoleOutTest() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint(new Square()).toConsoleOut();
        assertThat(out.toString(), is(new StringBuilder()
                .append("+++++++")
                .append("+     +")
                .append("+     +")
                .append("+++++++")
                .append(System.lineSeparator())
                .toString()));
    }
}
