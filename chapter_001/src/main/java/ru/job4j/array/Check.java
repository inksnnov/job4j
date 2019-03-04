package ru.job4j.array;

/**
 * Класс для работы с массивами типа boolean.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class Check {

    /**
     * Метод проверяет массив типа boolean заполнен ли он одинаковыми значениями.
     *
     * @param data boolean[] входящий массив.
     * @return boolean результат проверки.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
