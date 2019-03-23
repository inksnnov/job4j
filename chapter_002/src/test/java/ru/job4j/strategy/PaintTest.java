package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
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

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Выполнение перед началом теста.");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("Выполнение после теста.");
    }

    @Test
    public void toConsoleOutTestOne() {
        new Paint(new Square()).toConsoleOut();
        assertThat(out.toString(), is(new StringBuilder()
                .append("+++++++")
                .append("+     +")
                .append("+     +")
                .append("+++++++")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void toConsoleOutTestTwo() {
        new Paint(new Triangle()).toConsoleOut();
        assertThat(out.toString(), is(new StringBuilder()
                .append("   +   ")
                .append("  +++  ")
                .append(" +++++ ")
                .append("+++++++")
                .append(System.lineSeparator())
                .toString()));
    }
}
