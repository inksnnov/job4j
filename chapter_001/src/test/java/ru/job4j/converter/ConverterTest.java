package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 24.02.19.
 */
public class ConverterTest {
    @Test
    public void rubleToEuroTest() {
        Converter convert = new Converter();
        int result = convert.rubleToEuro(140);
        int expect = 2;
        assertThat(result, is(expect));
    }

    @Test
    public void rubleToDollarTest() {
        Converter convert = new Converter();
        int result = convert.rubleToDollar(180);
        int expect = 3;
        assertThat(result, is(expect));
    }
}
