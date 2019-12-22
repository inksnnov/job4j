package ru.job4j.list;

/**
 * Реализация проверки замыканий в связном списке.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class LinkedLocking<T> {

    /**
     * Метод проверяет наличие замыканий в цепочке связанного списка,
     * алгоритмом "Флойда".
     *
     * @param first начальная нода в цепочке.
     * @return true - цепь замкнута, иначе false.
     */
    public boolean hasCycle(Node<T> first) {
        boolean result = false;
        Node<T> tempOne = first, tempTwo = first;
        while (true) {
            int i = 0;
            while (i++ < 2) {
                if (tempTwo == null) {
                    break;
                }
                tempTwo = tempTwo.next;
            }
            tempOne = tempOne.next;
            if (tempOne == null || tempTwo == null) {
                break;
            }
            if (tempOne == tempTwo) {
                result = true;
                break;
            }
        }
        return result;
    }
}
