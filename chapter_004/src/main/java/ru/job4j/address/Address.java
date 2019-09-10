package ru.job4j.address;

/**
 * Класс-модель для хранения адреса.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Address {

    /**
     * Город.
     */
    private String city;

    /**
     * Улица.
     */
    private String street;

    /**
     * Номер дома.
     */
    private int home;

    /**
     * Номер квартиры.
     */
    private int apartment;

    /**
     * Конструктор инициализирует все поля класса.
     *
     * @param city      Город.
     * @param street    Улица.
     * @param home      Номер дома.
     * @param apartment Номер квартиры.
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }
}
