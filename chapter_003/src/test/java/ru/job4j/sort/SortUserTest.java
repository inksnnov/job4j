package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тесты к пакету ru.job4j.sort
 */
public class SortUserTest {

    @Test
    public void userCompareOneTest() {
        assertTrue((new User("Alex", 30).compareTo(
                new User("Igor", 25))) > 0);

    }

    @Test
    public void userCompareTwoTest() {
        assertTrue((new User("Igor", 30).compareTo(
                new User("Alex", 30))) > 0);
    }

    @Test
    public void userCompareThreeTest() {
        assertTrue((new User("Igor", 30).compareTo(
                new User("Igor", 30))) == 0);
    }

    @Test
    public void userCompareFourTest() {
        assertTrue((new User("Igor", 25).compareTo(
                new User("Igor", 30))) < 0);
    }

    @Test
    public void userCompareOneTestByAllFields() {
        List<User> input = new ArrayList<>(List.of(
                new User("A", 20),
                new User("A", 15),
                new User("B", 20)));
        new SortUser().sortByAllFields(input);
        assertThat(input.get(0).getAge(), is(15));
    }

    @Test
    public void userCompareTwoTestByAllFields() {
        List<User> input = new ArrayList<>(List.of(
                new User("B", 20),
                new User("A", 25),
                new User("B", 20)));
        new SortUser().sortByAllFields(input);
        assertThat(input.get(0).getAge(), is(25));
    }

    @Test
    public void userCompareOneTestByNameLength() {
        List<User> input = new ArrayList<>(List.of(
                new User("BA", 10),
                new User("A", 25),
                new User("BAAA", 20)));
        new SortUser().sortNameLength(input);
        assertThat(input.get(0).getAge(), is(25));
    }

    @Test
    public void userCompareTwoTestByNameLength() {
        List<User> input = new ArrayList<>(List.of(
                new User("BAAAA", 10),
                new User("AAAAAA", 25),
                new User("BAAA", 20)));
        new SortUser().sortNameLength(input);
        assertThat(input.get(0).getAge(), is(20));
    }
}
