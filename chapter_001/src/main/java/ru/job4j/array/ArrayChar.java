package ru.job4j.array;

/**
 * Класс для работы с массивами типа char.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 04.03.19.
 */
public class ArrayChar {

    private char[] data;

    /**
     * Принимает значение для поля data.
     *
     * @param line String.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Метод сравнивает входящий префикс с массивом char записанным в поле data.
     *
     * @param prefix String входящий префикс.
     * @return boolean результат проверки.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int cell = 0; cell < value.length; cell++) {
            if (value[cell] != this.data[cell]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
