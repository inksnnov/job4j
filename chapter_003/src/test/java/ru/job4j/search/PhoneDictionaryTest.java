package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест класса PhoneDictionary.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class PhoneDictionaryTest {

    @Test
    public void findTestOne() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        List<Person> persons = phones.find("petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void findTestTwo() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Ivanov", "12345678", "Moscow"));
        List<Person> persons = phones.find("12345678");
        assertThat(persons.iterator().next().getName(), is("Ivan"));
    }

    @Test
    public void findTestThree() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Ivan", "Ivanov", "12345678", "Moscow"));
        List<Person> persons = phones.find("32");
        assertTrue(persons.isEmpty());
    }
}
