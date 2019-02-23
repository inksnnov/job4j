package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Calculate class.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0
 */
public class CalculateTest {
    /**
     * Test echo method.
     */
    @Test
    public void whenTakeNameThenThreeEchoPlusName() {
        String input = "Petr Arsentev";
        String expect = "Echo, echo, echo : Petr Arsentev";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}