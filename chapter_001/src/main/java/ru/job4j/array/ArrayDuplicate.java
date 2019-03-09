package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс для работы с массивами типа String.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 05.03.19.
 */
public class ArrayDuplicate {

    /**
     * Метод ищет дубликаты в массиве, если найдены переставляет их в конец массива.
     *
     * @param array String входящий массив.
     * @return String возвращает массив без дубликатов.
     */
    public String[] remote(String[] array) {
        int count = 0;
        for (int row = 0; row < array.length - 1 - count; row++) {
            for (int cell = 1 + row; cell < array.length - count; cell++) {
                if (array[row].equals(array[cell])) {
                    String tmp = array[cell];
                    array[cell] = array[array.length - 1 - count];
                    array[array.length - 1 - count] = tmp;
                    count++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - count);
    }
}
