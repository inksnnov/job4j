package ru.job4j.list;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты к классу преобразования двумерного массива в ArrayList.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConvertMatrix2ListTest {

    private ConvertMatrix2List listConvert = new ConvertMatrix2List();

    @Test
    public void when2on2ArrayThenList4() {
        int[][] input = {
                {1, 2},
                {3, 4}};
        List<Integer> expect = List.of(
                1, 2, 3, 4
        );
        List<Integer> result = this.listConvert.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on3ArrayThenList9() {
        int[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = this.listConvert.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when3on25ArrayThenList8() {
        int[][] input = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8}};
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> result = this.listConvert.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on55ArrayThenList10() {
        int[][] input = {
                {1, 2}, {3, 4},
                {5, 6}, {7, 8},
                {9, 10}};
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = this.listConvert.toList(input);
        assertThat(result, is(expect));
    }

    @Test
    public void when2on65ArrayThenList11() {
        int[][] input = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11}};
        List<Integer> expect = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        List<Integer> result = this.listConvert.toList(input);
        assertThat(result, is(expect));
    }
}
