package ru.job4j.array;

/**
 * Класс для работы с массивами типа int.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class BubbleSort {

    /**
     * Метод сортирует массив типа int перестановкой.
     *
     * @param array int[] входящий массив.
     * @return int[] отсортированный массив.
     */
    public int[] sort(int[] array) {
        for (int row = array.length; row > 0; row--) {
            for (int cell = 1; row > cell; cell++) {
                if (array[cell - 1] > array[cell]) {
                    int tmp = array[cell];
                    array[cell] = array[cell - 1];
                    array[cell - 1] = tmp;
                }
            }
        }
        return array;
    }
}
