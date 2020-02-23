package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Реализация HashMap, поддерживает итератор.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class HashMap<K, V> implements Iterable<HashMap.Entry<K, V>> {
    /**
     * Массив-хранилище Entry объектов.
     */
    private Object[] table;
    /**
     * Дефолтный размер массива table.
     */
    private static final int DEFAULT_CAPACITY = 16;
    /**
     * Дефолтный коофицент заполнения массива table.
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    /**
     * Коофицент загрузки массива table.
     */
    private final float loadFactor;
    /**
     * Количество элементов в массиве table.
     */
    private int size;

    /**
     * Конструктор без параметров.
     * DEFAULT_CAPACITY = 16.
     * DEFAULT_LOAD_FACTOR = 0.75F
     */
    public HashMap() {
        this(0);
    }

    /**
     * Конструктор позволяет установить размер массива
     * table 16+.
     * DEFAULT_LOAD_FACTOR = 0.75F
     *
     * @param capacity int размер массива 16+.
     */
    public HashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Позволяет установить коофицент заполнения массива
     * перед расширением.
     * DEFAULT_CAPACITY = 16.
     *
     * @param loadFactor float коофицент заполнения.
     */
    public HashMap(float loadFactor) {
        this(0, loadFactor);
    }

    /**
     * Конструктор позволяет установить значения коофицента
     * заполнения и начального размера массива table.
     *
     * @param capacity   int начальный размер массива table.
     * @param loadFactor float коофицент заполнения.
     * @throws IllegalArgumentException - выкидывает если
     *                                  значение load_factor вне
     *                                  диапазона 0.1 - 1 или
     *                                  capacity < 0.
     */
    public HashMap(int capacity, float loadFactor) {
        if (loadFactor <= 0 || loadFactor > 1F) {
            throw new IllegalArgumentException("Не верное значение "
                    + "коофицента заполнения.");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Не верное значение "
                    + "размера коллекции.");
        }
        table = new Object[DEFAULT_CAPACITY + capacity];
        this.loadFactor = loadFactor;
    }

    /**
     * Метод добавляет пару ключ-значение в массив table,
     * позиция для добавления высчитываеться по хешкоду.
     * Если ячейка не пуста,значение не перезаписывается.
     *
     * @param key   Ключ.
     * @param value Значение.
     * @return если добавили true, если ячейка занята false.
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        int cell = hash(key);
        if (table[cell] == null) {
            table[cell] = new Entry<>(key, value);
            result = true;
            size++;
            checkResize();
        }
        return result;
    }

    /**
     * Получаем значение по ключу.
     * При этом смотрим чтобы индекс ключа не выходил за пределы
     * индексов массива.
     *
     * @param key Ключ.
     * @return <V> Значение, иначе null.
     */
    @SuppressWarnings("unchecked")
    public V get(K key) {
        V result = null;
        int cell = hash(key);
        if (cell < table.length && table[cell] != null) {
            Entry<K, V> bucket = (Entry<K, V>) table[cell];
            if (Objects.equals(bucket.key, key)) {
                result = bucket.value;
            }
        }
        return result;
    }

    /**
     * Удаляем значение из массива table
     * по хешу зануляя ячейку.
     *
     * @param key Ключ искомого объекта.
     * @return true удалено, иначе false.
     */
    @SuppressWarnings("unchecked")
    public boolean delete(K key) {
        int cell = hash(key);
        boolean result = false;
        if (cell < table.length && table[cell] != null) {
            Entry<K, V> bucket = (Entry<K, V>) table[cell];
            if (Objects.equals(bucket.key, key)) {
                table[cell] = null;
                result = true;
                size--;
            }
        }
        return result;
    }

    /**
     * Возвращаем количество элементов в массиве table.
     *
     * @return int количество элементов.
     */
    public int size() {
        return size;
    }

    /**
     * Проверка на пустую коллекцию.
     *
     * @return true коллекция пуста, иначе false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверяем требуеться ли расширение массива
     * исходя из коофицента загрузки.
     */
    private void checkResize() {
        if (size == Math.round(table.length * loadFactor)) {
            resize();
        }
    }

    /**
     * Расширяет массив с повторным хешированием всех элементов.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Object[] temp = new Object[table.length * 2];
        size = 0;
        for (Object entrySet : table) {
            if (entrySet != null) {
                Entry<K, V> entry = (Entry<K, V>) entrySet;
                temp[hash(entry.key)] = entrySet;
                size++;
            }
        }
        table = temp;
    }

    /**
     * Высчитываем индекс в массиве
     * для добавления, удаления или получения объектов на основе хешкода
     * ключа делением с остатком - остаток и  есть индекс.
     *
     * @param key Ключ объекта
     * @return индекс массива table.
     */
    private int hash(K key) {
        return key == null ? 0 : key.hashCode() % table.length;
    }

    /**
     * Итератор для HashMap.
     *
     * @return Итератор.
     */
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<>() {
            /**
             * Переменная записывает текущее количество элементов
             * в массиве table.
             */
            int modCount = size;
            /**
             * Позиция каретки.
             */
            int position;

            /**
             * Проверяем возможно ли вернуть следующее значение.
             *
             * @return true следующее значение есть, иначе false.
             * @throws ConcurrentModificationException кидаем если
             * обнаружены изменения в коллекции при итерировании.
             */
            @Override
            public boolean hasNext() {
                if (modCount != size) {
                    throw new ConcurrentModificationException("Обнаружены изменения"
                            + "в коллекции.");
                }
                boolean result = false;
                for (int i = position; i < table.length; i++) {
                    if (table[i] == null) {
                        position++;
                        continue;
                    }
                    result = true;
                    break;
                }
                return result;
            }

            /**
             * Возвращаем пару ключ-значение.
             *
             * @return Entry<K, V>.
             * @throws NoSuchElementException если следующего
             * элемента для возврата нет.
             */
            @SuppressWarnings("unchecked")
            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (Entry<K, V>) table[position++];
            }
        };
    }

    /**
     * Модель хранения пары ключ-значения.
     *
     * @param <K> Ключ.
     * @param <V> Значение.
     */
    static class Entry<K, V> {
        public K key;
        public V value;

        /**
         * Дефолтный конструктор заполняет поля key, value.
         *
         * @param key   Ключ.
         * @param value Значение.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
