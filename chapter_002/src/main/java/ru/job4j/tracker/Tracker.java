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
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод заменяет созданную ранее заявку в массиве items.
     * Id берем из заменяемой заявки.
     *
     * @param id   заявки которую  нужно заменить.
     * @param item Объект новой заявки.
     * @return возвращает true если замена прошла успешно, иначе false.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                item.setId(id);
                this.items[i] = item;
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
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                result = true;
                this.position--;
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
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Поиск заявки по имени.
     *
     * @param name имя искомой заявки.
     * @return Item[] массив заявок с искомыми именами.
     */
    public Item[] findByName(String name) {
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name)) {
                Item tmp = this.items[count];
                this.items[count++] = this.items[i];
                this.items[i] = tmp;
            }
        }
        return Arrays.copyOf(this.items, count);
    }

    /**
     * Поиск заявки по Id.
     *
     * @param id искомое Id.
     * @return Возвращает найденную заявку, иначе null.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }

    /**
     * Генерация уникального Id для каждой созданной заявки.
     *
     * @return Id заявки.
     */
    private String generateId() {
        return String.valueOf((long) (Math.random() * System.currentTimeMillis()));
    }
}
