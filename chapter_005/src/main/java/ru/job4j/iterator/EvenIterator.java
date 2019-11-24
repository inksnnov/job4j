package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс итератор, возвращает только четные элементы из массива чисел.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.1.
 */
public class EvenIterator implements Iterator {

    /**
     * Входной массив чисел.
     */
    private final int[] values;

    /**
     * Позиция каретки в массиве.
     */
    private int index = 0;

    /**
     * Конструктор, принимает в себя массив чисел.
     *
     * @param values массив целых чисел.
     */
    public EvenIterator(int[] values) {
        this.values = values;
    }

    /**
     * Метод проверяет, есть ли справа от каретки четное число,
     * если есть возвращет true, иначе false.
     *
     * @return true если справа положительное число.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if (values[i] != 0 && values[i] % 2 == 0) {
                result = true;
                index = i;
                break;
            }
        }
        return result;

    }

    /**
     * Метод возвращает положительное число справа от каретки и передвигает ее на +1.
     *
     * @return положительное число.
     * @throws NoSuchElementException если положительных чисел справа больше нет, выкидываем исключение.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }


}
