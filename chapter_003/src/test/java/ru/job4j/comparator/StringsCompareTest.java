package ru.job4j.comparator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringsCompareTest {

    private ListCompare compare = new ListCompare();

    @Test
    public void whenStringsAreEqualThenZero() {
        int rst = this.compare.compare(
                "Ivanov",
                "Ivanov");
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        int rst = this.compare.compare(
                "Ivanov",
                "Ivanova");
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        int rst = this.compare.compare(
                "Petrov",
                "Ivanova");
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        int rst = this.compare.compare(
                "Petrov",
                "Patrov");
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        int rst = this.compare.compare(
                "Patrova",
                "Petrov");
        assertThat(rst, lessThan(0));
    }

    @Test
    public void compareListCharOneTest() {
        List<Character> list1 = List.of('h', 'e', 'l', 'l', 'o');
        List<Character> list2 = List.of('h', 'e', 'l', 'l', 'o');
        int result = this.compare.compareLIst(list1, list2);
        assertThat(result, is(0));
    }

    @Test
    public void compareListCharTwoTest() {
        List<Character> list1 = List.of('h', 'e', 'l', 'l');
        List<Character> list2 = List.of('h', 'e', 'l', 'l', 'o');
        int result = this.compare.compareLIst(list1, list2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void compareListCharThreeTest() {
        List<Character> list1 = List.of('h', 'e', 'l', 'l', 'o');
        List<Character> list2 = List.of('h', 'e', 'l', 'l');
        int result = this.compare.compareLIst(list1, list2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareListCharFourTest() {
        List<Character> list1 = List.of('P', 'e', 't', 'r', 'o', 'v', 'a');
        List<Character> list2 = List.of('I', 'v', 'a', 'n', 'o', 'v', 'a');
        int result = this.compare.compareLIst(list1, list2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareListCharSixTest() {
        List<Character> list1 = List.of('P', 'e');
        List<Character> list2 = List.of('e', 'p');
        int result = this.compare.compareLIst(list1, list2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareListCharSevenTest() {
        List<Character> list1 = List.of('e', 'p');
        List<Character> list2 = List.of('p', 'e');
        int result = this.compare.compareLIst(list1, list2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void compareListCharEightTest() {
        List<Character> list1 = List.of('e', 'p');
        List<Character> list2 = List.of();
        int result = this.compare.compareLIst(list1, list2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareListCharNineTest() {
        List<Character> list1 = List.of();
        List<Character> list2 = List.of('e', 'p');
        int result = this.compare.compareLIst(list1, list2);
        assertThat(result, lessThan(0));
    }

}