package ru.job4j.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
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
}
