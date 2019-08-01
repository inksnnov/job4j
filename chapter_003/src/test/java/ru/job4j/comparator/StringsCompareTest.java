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
    @Test
    public void whenStringsAreEqualThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void compareListCharOneTest() {
        ListCompare compare = new ListCompare();
        List<Character> list1 = new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
        List<Character> list2 = new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
        int result = compare.compareLIst(list1, list2);
        assertThat(result, is(0));
    }

    @Test
    public void compareListCharTwoTest() {
        ListCompare compare = new ListCompare();
        List<Character> list1 = new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l'));
        List<Character> list2 = new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
        int result = compare.compareLIst(list1, list2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void compareListCharThreeTest() {
        ListCompare compare = new ListCompare();
        List<Character> list1 = new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
        List<Character> list2 = new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l'));
        int result = compare.compareLIst(list1, list2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareListCharFourTest() {
        ListCompare compare = new ListCompare();
        List<Character> list1 = new ArrayList<>(Arrays.asList('P', 'e', 't', 'r', 'o', 'v', 'a'));
        List<Character> list2 = new ArrayList<>(Arrays.asList('I', 'v', 'a', 'n', 'o', 'v', 'a'));
        int result = compare.compareLIst(list1, list2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareListCharSixTest() {
        ListCompare compare = new ListCompare();
        List<Character> list1 = new ArrayList<>(Arrays.asList('P', 'e'));
        List<Character> list2 = new ArrayList<>(Arrays.asList('e', 'p'));
        int result = compare.compareLIst(list1, list2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareListCharSevenTest() {
        ListCompare compare = new ListCompare();
        List<Character> list1 = new ArrayList<>(Arrays.asList('e', 'p'));
        List<Character> list2 = new ArrayList<>(Arrays.asList('p', 'e'));
        int result = compare.compareLIst(list1, list2);
        assertThat(result, lessThan(0));
    }

    @Test
    public void compareListCharEightTest() {
        ListCompare compare = new ListCompare();
        List<Character> list1 = new ArrayList<>(Arrays.asList('e', 'p'));
        List<Character> list2 = new ArrayList<>();
        int result = compare.compareLIst(list1, list2);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareListCharNineTest() {
        ListCompare compare = new ListCompare();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>(Arrays.asList('e', 'p'));
        int result = compare.compareLIst(list1, list2);
        assertThat(result, lessThan(0));
    }

}