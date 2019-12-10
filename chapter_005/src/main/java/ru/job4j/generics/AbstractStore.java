package ru.job4j.generics;

import java.util.Iterator;

/**
 * Реализация общих методов для классов User и Role.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Хранилище моделей User или Role.
     */
    private SimpleArray<T> array;

    /**
     * Конструктор по умолчанию задает размер хранилища.
     *
     * @param size размер хранилища.
     */
    public AbstractStore(int size) {
        array = new SimpleArray<>(size);
    }

    /**
     * Добавляем объект в хранилище array.
     * Если мест для добавления объектов нет, метод add в классе SimpleArray бросает исключение.
     *
     * @param model добавляемый объект T extends Base.
     * @throws ArrayStoreException Если Id объекта существует в хранилище, бросаем исключение.
     */
    @Override
    public void add(T model) {
        if (findIdxById(model.getId()) < 0) {
            array.add(model);
        } else {
            throw new ArrayStoreException("This id already exists");
        }
    }

    /**
     * Заменяем объект новым, поиск заменяемого объекта производим по id.
     *
     * @param id    Id заменяемого объекта.
     * @param model новый объект.
     * @return true - объект успешно заменен, иначе false.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = findIdxById(id);
        if (index >= 0) {
            array.set(index, model);
            result = true;
        }
        return result;
    }

    /**
     * Удаляем объект из хранилища, ищем его по Id.
     *
     * @param id Id удаляемого объекта.
     * @return true - объект удален, иначе false.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = findIdxById(id);
        if (index >= 0) {
            array.remove(index);
            result = true;
        }
        return result;
    }

    /**
     * Поиск объекта по Id.
     * Если Id не верный или его нет в хранилище
     * метод get класса SimpleArray кидает NoSuchElementException.
     *
     * @param id Id искомого объекта.
     * @return Искомый объект.
     */
    @Override
    public T findById(String id) {
        return array.get(findIdxById(id));
    }

    /**
     * Метод определяет индекс объекта по Id.
     *
     * @param id Id искомого объекта.
     * @return индекс объекта, если индекс отсутствует то -1.
     */
    private int findIdxById(String id) {
        Iterator<T> iterator = array.iterator();
        int index = iterator.hasNext() ? 0 : -1;
        while (iterator.hasNext()) {
            T temp = iterator.next();
            if (temp.getId().equalsIgnoreCase(id)) {
                break;
            }
            if (!iterator.hasNext()) {
                index = -1;
                break;
            }
            index++;
        }
        return index;
    }
}
