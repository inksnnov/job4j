package ru.job4j.user;

/**
 * Класс пользователя.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */

public class User {

    /**
     * Id пользователя.
     */
    private Long id;

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Место проживания.
     */
    private String city;

    /**
     * Инициализируем объект User при создании, заполняем поля name, city и генерируем id.
     *
     * @param name Имя.
     * @param city Город проживания.
     */
    public User(String name, String city) {
        this.id = this.generateId();
        this.name = name;
        this.city = city;
    }

    /**
     * Возвращаем id.
     *
     * @return Long id
     */
    public Long getId() {
        return id;
    }

    /**
     * Возвращаем имя.
     *
     * @return String name.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращаем город проживания.
     *
     * @return String city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Генерируем id юзера из времени в мс.
     *
     * @return Long id.
     */
    private Long generateId() {
        return System.currentTimeMillis();
    }
}
