package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void addTest() {
        Calculator calc = new Calculator();
        calc.add(2D, 4D);
        double result = calc.getResult();
        double expect = 6D;
        assertThat(result, is(expect));
    }

    @Test
    public void subtractTest() {
        Calculator calc = new Calculator();
        calc.subtract(10D, 4D);
        double result = calc.getResult();
        double expect = 6D;
        assertThat(result, is(expect));
    }

    @Test
    public void divTest() {
        Calculator calc = new Calculator();
        calc.div(8D, 4D);
        double result = calc.getResult();
        double expect = 2D;
        assertThat(result, is(expect));
    }

    @Test
    public void multipleTest() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 4D);
        double result = calc.getResult();
        double expect = 8D;
        assertThat(result, is(expect));
    }
}
