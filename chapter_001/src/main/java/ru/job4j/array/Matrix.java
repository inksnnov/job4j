package ru.job4j.array;

/**
 * Класс для работы с двумерными массивами типа int.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class Matrix {

    /**
     * Класс реализует таблицу умножения в двумерном массиве.
     *
     * @param size int размер матрицы.
     * @return int[][] матрица с таблицой умножения размером size.
     */
    public int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                result[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return result;
    }
}
