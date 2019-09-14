package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

/**
 * Тесты к классу преобразования листа в двумерный массив и листа массивов int в List int.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConvertList2ArrayTest {

    private ConvertList2Array listConvert = new ConvertList2Array();

    @Test
    public void when7ElementsThen9() {
        int[][] result = this.listConvert.toArray(List.of(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when6ElementsThen6() {
        int[][] result = this.listConvert.toArray(List.of(1, 2, 3, 4, 5, 6), 2);
        int[][] expect = {{1, 2, 3}, {4, 5, 6}};
        assertThat(result, is(expect));
    }

    @Test
    public void when10ElementsThen6() {
        int[][] result = this.listConvert.toArray(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 6);
        int[][] expect = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {0, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when3ElementsThen2() {
        int[][] result = this.listConvert.toArray(List.of(1, 2, 3), 2);
        int[][] expect = {{1, 2}, {3, 0}};
        assertThat(result, is(expect));
    }

    @Test
    public void when1ElementsThen6() {
        int[][] result = this.listConvert.toArray(List.of(1), 6);
        int[][] expect = {{1}, {0}, {0}, {0}, {0}, {0}};
        assertThat(result, is(expect));
    }

    @Test
    public void convertListOfIntArraysList8ToList() {
        List<int[]> input = List.of(
                new int[]{1, 2, 3},
                new int[]{4, 5, 6, 7, 8});
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(this.listConvert.convert(input), is(expect));
    }

    @Test
    public void convertListOfIntArraysList11ToList() {
        List<int[]> input = List.of(
                new int[]{1, 2, 3},
                new int[]{4, 5},
                new int[]{6, 7, 8, 9, 10},
                new int[]{11});
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        assertThat(this.listConvert.convert(input), is(expect));
    }
}
