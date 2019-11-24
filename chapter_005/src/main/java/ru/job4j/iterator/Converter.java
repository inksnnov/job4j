package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс конвертирует итератор итераторов в один итератор.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Converter {

    /**
     * Переменная хранит внутренний итератор.
     */
    private Iterator<Integer> inner;

    /**
     * Метод конвертирует итератор итераторов и один последовательный итератор.
     * При первом вызове метода записывает в поле inner первый вложенный итератор.
     *
     * @param it Итератор итераторов
     * @return сконвертированный итератор.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        if (inner == null) {
            inner = it.next();
        }

        return new Iterator<>() {

            /**
             * Метод проверяет в цикле есть ли значение, перемещаясь по внутренним
             * итераторам пока не найдет значение для выдачи иначе варнет false.
             *
             * @return вернет true если следующее значение найдено, иначе false.
             */
            public boolean hasNext() {
                while (!inner.hasNext()) {
                    if (it.hasNext()) {
                        inner = it.next();
                        continue;
                    }
                    break;
                }
                return inner.hasNext();

            }

            /**
             * Возвращает следующий элемент итератора вызывая метод hasNext для проверки и
             * перемещения каретки.
             *
             * @throws NoSuchElementException бросает если значения для вовзрата не найдены.
             * @return следующее значение итератора.
             */
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return inner.next();
            }
        };
    }
}
