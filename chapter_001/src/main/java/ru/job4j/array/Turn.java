package ru.job4j.array;

/**
 * Класс для работы с массивами чисел int.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class Turn {

    /**
     * Метод инвертирует входящий массив чисел.
     *
     * @param input int[] входящий массив.
     * @return int[] перевернутый массив.
     */
    public int[] back(int[] input) {
        for (int i = 0; i < input.length / 2; i++) {
            int temp = input[i];
            input[i] = input[input.length - i - 1];
            input[input.length - i - 1] = temp;
        }
        return input;
    }
}
