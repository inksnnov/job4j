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
        for (int i = 0; i < array.length - 1 - count; i++) {
            for (int j = 1 + i; j < array.length - count; j++) {
                if (array[i].equals(array[j])) {
                    String tmp = array[j];
                    array[j] = array[array.length - 1 - count];
                    array[array.length - 1 - count] = tmp;
                    count++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - count);
    }
}
