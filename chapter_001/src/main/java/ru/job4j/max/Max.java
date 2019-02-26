package ru.job4j.max;

/**
 * Вычисление максималього числа из двух.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 26.02.19.
 */
public class Max {

    /**
     * Метод возвращает максимальное число из двух принятых агрументами.
     *
     * @param first  int первое число.
     * @param second int второе число.
     * @return int максимальное число.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
