package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализация итератора для двумерных массивов.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.1.
 */
public class ArrayIterator<T> implements Iterator<T> {

    /**
     * Сохраняем массив.
     */
    private final T[][] values;

    /**
     * Строка(для перемещения в цикле).
     */
    private int row = 0;

    /**
     * Ячейка(для перемещения в цикле).
     */
    private int cell = 0;

    /**
     * Конструктор принимает массив для итерации.
     *
     * @param values массив.
     */
    public ArrayIterator(T[][] values) {
        this.values = values;
    }

    /**
     * Проверяем возможно ли дальнейшее перемещение каретки.
     *
     * @return каретка готова к перемещению на +1 - true, иначе false.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        if (row < values.length) {
            if (cell < values[row].length) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод возвращает объект T в случае если он имееться и записываем следующую позицию
     * в поле cell, если достигнут предел вложенного массива сбрасываем cell в ноль и
     * прибавляем row + 1, проверка возможности выдачи объекта Т осуществляеться
     * вызовом метода hasNext.
     *
     * @return элемент T.
     * @throws NoSuchElementException бросаем в случае отсутствия элемент для возврата.
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T result = values[row][cell++];
        if (cell == values[row].length) {
            cell = 0;
            row++;
        }
        return result;
    }
}
