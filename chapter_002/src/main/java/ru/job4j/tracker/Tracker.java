package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Класс манипулирует объектами типа Item.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 12.03.19.
 */
public class Tracker {

    /**
     * Массив- хранилище объектов типа Item, хранит заявки.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель на ячейку в массиве Items,при записи в ячейку сдвигаеться на 1 вправо,
     * при удалении на 1 влево.
     */
    private int position = 0;

    /**
     * Метод добавления заявки(Item) в массив Items.
     *
     * @param item Созданая заявки.
     * @return Item возвращает созданную заявку.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Метод заменяет созданную ранее заявку в массиве items.
     *
     * @param id   заявки которую  нужно заменить.
     * @param item Объект новой заявки.
     * @return возвращает true если замена прошла успешно, иначе false.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                item.setId(this.generateId());
                items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет созданную заявку из массива items, сдвигая
     * элементы после удаленной ячейки на 1 позицию влево и
     * перемещает курсор - position так же влево на единицу.
     *
     * @param id удаляемой заявки?
     * @return если заявка удалена возвращает true, иначе false.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - i - 1);
                result = true;
                position--;
                break;
            }
        }
        return result;
    }

    /**
     * Возвращает все заявки из массива items.
     *
     * @return Возващает массив без null элементов и без стертых заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Поиск заявки по имени.
     *
     * @param name имя искомой заявки.
     * @return найденная заявка, иначе null.
     */
    public Item findByName(String name) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getName().equals(name)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Поиск заявки по Id.
     *
     * @param id искомое Id.
     * @return Возвращает найденную заявку, иначе null.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Генерация уникального Id для каждой созданной или
     * замененной заявки.
     *
     * @return Id заявки.
     */
    private String generateId() {
        return String.valueOf((long) (Math.random() * System.currentTimeMillis()));
    }
}
