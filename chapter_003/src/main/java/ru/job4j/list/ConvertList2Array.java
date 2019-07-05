package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Конвертация List в двумерный массив с заданным количеством ячеек.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConvertList2Array {

    /**
     * Метод конвертации List в двумерный массив с заданным количеством
     * подмассивов, пустые клетки заполняються нулями.
     * Считаем сколько нам нужно добавить ячеек для равномерного заполнения
     * массива и добавляем нули в list.
     * Создаем выходной массив с кол-вом строк rows и ячеек cells/rows.
     * В цикле foreach заполняем массив.
     *
     * @param input входной List.
     * @param rows  количество строк(подмассивов) на выходе.
     * @return двумерный массив
     */
    public int[][] toArray(List<Integer> input, int rows) {
        int cells = input.size();
        while (!(cells % rows == 0)) {
            cells++;
        }
        int[][] array = new int[rows][cells / rows];
        int i = 0, j = 0;
        for (Integer result : input) {
            if (j == cells / rows) {
                i++;
                j = 0;
            }
            array[i][j++] = result;
        }
        return array;
    }
}
