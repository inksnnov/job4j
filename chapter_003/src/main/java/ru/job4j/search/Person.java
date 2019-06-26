package ru.job4j.search;

/**
 * Класс реализация записи в телефонный справочник.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Person {

    /**
     * Поле содержит имя.
     */
    private String name;

    /**
     * Поле содержит фамилию.
     */
    private String surname;

    /**
     * Поле содержит номер телефона.
     */
    private String phone;

    /**
     * Поле содержит адрес.
     */
    private String address;

    /**
     * Конструкор инициализирует все поля(Имя, Фамилия, Номер телефона, Адрес).
     *
     * @param name    String Имя.
     * @param surname String Фамилия.
     * @param phone   String Номер телефона.
     * @param address String Адрес.
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Возвращает Имя
     *
     * @return String this.name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает Фамилию.
     *
     * @return String this.surname.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Возвращает номер телефона.
     *
     * @return this.phone.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Возвращает адрес.
     *
     * @return this.address.
     */
    public String getAddress() {
        return this.address;
    }
}
