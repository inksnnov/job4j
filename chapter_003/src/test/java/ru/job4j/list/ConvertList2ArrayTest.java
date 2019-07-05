package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

/**
 * Тесты к классу преобразования листа в двумерный массив.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when6ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6), 2);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}};
        assertThat(result, is(expect));
    }

    @Test
    public void when10ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 6);
        int[][] expect = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when3ElementsThen2() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3), 2);
        int[][] expect = {{1, 2}, {3, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when1ElementsThen6() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1), 6);
        int[][] expect = {{1}, {0}, {0}, {0}, {0}, {0}};
        assertThat(result, is(expect));
    }

}
