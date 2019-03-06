package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 05.03.19.
 */
public class ArrayDuplicateTest {

    @Test
    public void removeTestOne() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remote(input);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertArrayEquals(result, expect);
    }

    @Test
    public void removeTestTwo() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир", "Пока"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remote(input);
        String[] expect = {"Привет", "Мир", "Пока", "Супер"};
        assertArrayEquals(result, expect);
    }
}
