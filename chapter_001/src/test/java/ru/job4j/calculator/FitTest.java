package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 24.02.19.
 */
public class FitTest {

    @Test
    public void manWeightTestOne() {
        Fit fit = new Fit();
        double result = fit.manWeight(190D);
        assertThat(result, closeTo(103.5D, 0.1D));
    }

    @Test
    public void womanWeightTestOne() {
        Fit fit = new Fit();
        double result = fit.womanWeight(165D);
        assertThat(result, closeTo(63.25D, 0.1D));
    }
}
