package ru.job4j.array;

/**
 * Класс для работы с массивами чисел.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class FindLoop {

    /**
     * Метод поиска в массиве заданного числа.
     *
     * @param data int[] входящий массив.
     * @param el   int искомое число в массиве.
     * @return int index искомого числа в массиве.
     */
    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int cell = 0; cell < data.length; cell++) {
            if (data[cell] == el) {
                result = cell;
                break;
            }
        }
        return result;
    }
}
