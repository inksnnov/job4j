package ru.job4j.loop;

/**
 * Расчет факториала.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class Factorial {

    /**
     * Метод расчета факториала.
     *
     * @param n int от какого числа расчитывать факториал.
     * @return int factorial.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
