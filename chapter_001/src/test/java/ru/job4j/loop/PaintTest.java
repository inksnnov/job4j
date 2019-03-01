package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class PaintTest {

    @Test
    public void pyramidTest() {
        Paint paint = new Paint();
        String result = paint.pyramid(3);
        System.out.println(result);
        assertThat(result, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("  ^  ")
                .add(" ^^^ ")
                .add("^^^^^")
                .toString()));
    }
}
