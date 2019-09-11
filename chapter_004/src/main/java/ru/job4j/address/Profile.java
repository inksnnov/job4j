package ru.job4j.address;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return address.equals(profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
