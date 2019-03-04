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
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
        return array;
    }
}
