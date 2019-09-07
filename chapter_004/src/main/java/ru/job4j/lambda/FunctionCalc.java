package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * Класс для работы c математическими функциями через лямбда-выражения.
 */
public class FunctionCalc {


    /**
     * Метод подсчета функций в выбранном диапазоне чисел.
     *
     * @param start стартовое число.
     * @param end   конечное  число.
     * @param func  функциональный интерфейс UnaryOperator - принимает, возвращает Double.
     * @return Подсчитанный список чисел в диапазоне.
     */
    public static List<Double> diapason(int start, int end, UnaryOperator<Double> func) {
        List<Double> result = new ArrayList<>();
        for (int x = start; x != end; x++) {
            result.add(func.apply((double) x));
        }
        return result;
    }
}
