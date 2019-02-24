package ru.job4j.calculator;

/**
 * Расчет веса.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 24.02.19.
 */
public class Fit {

    /**
     * Расчет идеального веса для мужчин.
     *
     * @param height double рост.
     * @return double идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15D;
    }

    /**
     * Расчет идеального веса для женщин.
     *
     * @param height double рост.
     * @return double идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15D;
    }
}
