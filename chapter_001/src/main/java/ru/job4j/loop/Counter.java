package ru.job4j.loop;

/**
 * Подсчет суммы четных чисел в диапазоне.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class Counter {

    /**
     * Метод складывает все четные числа в диапазоне start-finish.
     *
     * @param start  int начальное число.
     * @param finish int конечное число.
     * @return int сумма четных чисел.
     */
    public int add(int start, int finish) {
        int i = start;
        int result = 0;
        for (; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
