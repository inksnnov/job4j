package ru.job4j.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toList());
    }
}
