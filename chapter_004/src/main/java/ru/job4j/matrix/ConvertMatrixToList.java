package ru.job4j.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для работы с коллекциями средствами Stream API.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConvertMatrixToList {

    /**
     * Метод конвертирует двухмерный массив Integer в одномерный
     * список чисел с помощью Stream API.
     *
     * @param matrix List<List<Integer>>.
     * @return List<Integer>
     */
    public List<Integer> convert(Integer[][] matrix) {
        return Arrays.stream(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
