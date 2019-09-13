package ru.job4j.matrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты к классу ConvertMatrixToList.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConvertMatrixToListTest {

    @Test
    public void convertTestOne() {
        Integer[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        List<Integer> result = new ConvertMatrixToList().convert(input);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expect));
    }
}
