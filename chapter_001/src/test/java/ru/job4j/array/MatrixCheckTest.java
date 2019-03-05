package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 05.03.19.
 */
public class MatrixCheckTest {

    @Test
    public void monoTestOne() {
        boolean[][] input = {{true, false}, {false, true}};
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void monoTestTwo() {
        boolean[][] input = {{true, false}, {false, false}};
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void monoTestThree() {
        boolean[][] input = {{true, true, true}, {false, true, true}, {true, false, true}};
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void monoTestFour() {
        boolean[][] input = {{true, true, true}, {false, true, true}, {false, false, true}};
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean result = matrixCheck.mono(input);
        assertThat(result, is(false));
    }
}
