package ru.job4j.calculator;

/**
 * Элементарный калькулятор.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0
 * @since 24.02.2019.
 */
public class Calculator {

    /**
     * Поле хранит значение вычислений методов класса.
     */
    private double result;

    /**
     * Сложение (записывает значение в поле result).
     *
     * @param first  double.
     * @param second double.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычитание (записывает значение в поле result).
     *
     * @param first  double.
     * @param second double.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Деление (записсывает значение в поле result).
     *
     * @param first  double.
     * @param second double.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Умножение (зписывает значение в поле result).
     *
     * @param first  double.
     * @param second double.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Возвращает значение поля result.
     *
     * @return double.
     */
    public double getResult() {
        return this.result;
    }


}
