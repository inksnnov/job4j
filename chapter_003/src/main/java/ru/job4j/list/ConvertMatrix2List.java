package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * класс преобразования двумерного массива в ArrayList.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConvertMatrix2List {

    /**
     * Метод конвертирует двумерный массив в ArrayList.
     * Используется два цикла foreach для обхода строк и ячеек.
     *
     * @param array входной массив.
     * @return сконвертированный ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] result : array) {
            for (int cell : result) {
                list.add(cell);
            }
        }
        return list;
    }
}
