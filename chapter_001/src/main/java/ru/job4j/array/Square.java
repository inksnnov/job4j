package ru.job4j.array;

/**
 * Реализация заполнения массива степенями чисел.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 03.03.19.
 */
public class Square {

    /**
     * Метод реализует заполнение массива int степенями чисел от 1 до n.
     *
     * @param bound int конечное число в массиве.
     * @return int[] массив заполеннный степенями чисел.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int cell = 1; cell <= bound; cell++) {
            result[cell - 1] = cell * cell;
        }
        return result;
    }
}
