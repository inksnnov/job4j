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
        for (int cell = 0; cell < input.length / 2; cell++) {
            int temp = input[cell];
            input[cell] = input[input.length - cell - 1];
            input[input.length - cell - 1] = temp;
        }
        return input;
    }
}
