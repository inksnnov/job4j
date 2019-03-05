package ru.job4j.array;

/**
 * Класс для работы с двумерными массивами типа boolean.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 05.03.19.
 */
public class MatrixCheck {

    /**
     * Метод проверки заполнненности двумерного массива значением true или false по
     * диагонали.
     *
     * @param data boolean[][] входящий масскив.
     * @return boolean если по двум разным диагоналям массив заполнен одиинаковыми
     * значениями вернет true, иначе false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1] ||
                    data[i][data.length - 1 - i] != data[i + 1][data.length - 2 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
