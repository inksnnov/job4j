package ru.job4j.set;

import ru.job4j.list.DynamicContainer;

import java.util.Iterator;
import java.util.Objects;

/**
 * Реализация коллекции Set на ArrayList.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SimpleSet<E> implements Iterable<E> {
    /**
     * Контейнер ArrayList.
     */
    private DynamicContainer<E> container;

    /**
     * Дефолтный конструктор, инициализирует контейнер.
     */
    public SimpleSet() {
        container = new DynamicContainer<>();
    }

    /**
     * Метод добавляет элемент в коллекцию(дубликаты не добавляються).
     *
     * @param value E элемент.
     * @return true если добавили, иначе false.
     */
    public boolean add(E value) {
        boolean result = check(value);
        if (result) {
            container.add(value);
        }
        return result;
    }

    /**
     * Возвращаем объект итератора.
     *
     * @return Iterator<E>.
     */
    @Override
    public Iterator<E> iterator() {
        return container.iterator();
    }

    /**
     * Выполняем проверку на дубликаты.
     *
     * @param value добавляемый элемент.
     * @return true - совпадения отсутсвуют, иначе false.
     */
    private boolean check(E value) {
        boolean result = true;
        Iterator<E> iterator = container.iterator();
        while (iterator.hasNext()) {
            if (Objects.equals(value, iterator.next())) {
                result = false;
                break;
            }
        }
        return result;
    }
}
