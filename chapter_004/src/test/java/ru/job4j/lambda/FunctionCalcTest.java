package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionCalcTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void quadraticFunctionTestOne() {
        List<Double> result = FunctionCalc.diapason(5, 8, x -> 2 * (x * x) + 2 * x + 1);
        List<Double> expected = Arrays.asList(61D, 85D, 113D);
        assertThat(result, is(expected));
    }

    @Test
    public void logFunctionTestOne() {
        List<Double> result = FunctionCalc.diapason(1, 4, Math::log);
        List<Double> expected = Arrays.asList(0D, 0.6931471805599453D, 1.0986122886681098D);
        assertThat(result, is(expected));
    }
}
