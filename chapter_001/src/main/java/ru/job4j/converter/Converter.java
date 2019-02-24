package ru.job4j.converter;

/**
 * Конвертер валюты.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 24.02.2019.
 */
public class Converter {

    /**
     * Конвертер рубли в евро.
     *
     * @param value int рубли.
     * @return int euro.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертер рубли в доллары.
     *
     * @param value int рубли.
     * @return int dollars.
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }


}
