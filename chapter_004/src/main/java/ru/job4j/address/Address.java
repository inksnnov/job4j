package ru.job4j.address;

import java.util.Objects;

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

    /**
     * Получаем город.
     *
     * @return City.
     */
    public String getCity() {
        return this.city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return this.home == address.home &&
                apartment == address.apartment &&
                city.equals(address.city) &&
                street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
