package ru.job4j.address;

/**
 * Профиль клиента, хранит в себе адрес.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Profile {

    /**
     * Адрес клиента.
     */
    private Address address;

    /**
     * Инициализируем поля.
     *
     * @param address Адрес.
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**
     * Вернуть адрес клиента.
     *
     * @return Address.
     */
    public Address getAddress() {
        return address;
    }
}
