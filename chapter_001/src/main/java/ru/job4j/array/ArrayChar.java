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
        for (int i = 0; i < value.length; i++) {
            if (value[i] != this.data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
