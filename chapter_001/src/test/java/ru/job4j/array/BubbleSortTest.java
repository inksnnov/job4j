package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class BubbleSortTest {

    @Test
    public void sortTestOne() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {4, 1, 6, 9, 2, 5, 3, 9, 2, 7};
        int[] result = bubbleSort.sort(arr);
        int[] expect = {1, 2, 2, 3, 4, 5, 6, 7, 9, 9};
        assertArrayEquals(result, expect);
    }

    @Test
    public void sortTestTwo() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {3, 3, 3, 3, 3, 2, 7, 3, 3, 1};
        int[] result = bubbleSort.sort(arr);
        int[] expect = {1, 2, 3, 3, 3, 3, 3, 3, 3, 7};
        assertArrayEquals(result, expect);
    }
}
