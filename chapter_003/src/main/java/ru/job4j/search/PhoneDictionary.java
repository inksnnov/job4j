package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализация поиска по телефонному справочнику.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class PhoneDictionary {
    /**
     * Храним телефонный справочник.
     */
    private List<Person> persons = new ArrayList<>();

    /**
     * Метод добывляет запись в справочник.
     *
     * @param person объект справочника, содержит поле Имя, Фамилия, Адрес, Номер телефона.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод поиска по телефонному справочнику, от трех символов, без учета регистра.
     *
     * @param key String искомый набор символов.
     * @return Возвращает ArrayList всех объектов в которых найдены искомые символы,
     * иначе возвращает пустой ArrayList.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (key.length() >= 3 && (person.getAddress().toLowerCase().contains(key.toLowerCase())
                    || person.getName().toLowerCase().contains(key.toLowerCase())
                    || person.getPhone().toLowerCase().contains(key.toLowerCase())
                    || person.getSurname().toLowerCase().contains(key.toLowerCase()))) {
                result.add(person);
            }
        }
        return result;
    }
}
