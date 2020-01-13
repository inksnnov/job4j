package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Тесты к реализации HashMap.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class HashMapTest {
    private HashMap<String, String> map;

    @Before
    public void load() {
        map = new HashMap<>();
    }

    @Test
    public void mapTestOne() {
        assertTrue(map.insert("Abc", "Abc"));
        assertFalse(map.insert("Abc", "Abc"));
        assertThat(map.get("Abc"), is("Abc"));
        assertTrue(map.delete("Abc"));
        assertTrue(map.isEmpty());
    }

    @Test
    public void mapTestTwo() {
        assertTrue(map.insert("Abc", "Abc"));
        assertFalse(map.delete("AAA"));
        assertFalse(map.delete(null));
        assertThat(map.size(), is(1));
    }

    @Test
    public void mapTestThree() {
        assertTrue(map.insert(null, "Abc"));
        assertThat(map.get(null), is("Abc"));
        assertTrue(map.delete(null));
        assertThat(map.size(), is(0));
    }

    @Test
    public void mapTestFour() {
        assertTrue(map.insert(null, null));
        assertTrue(map.insert("AAA", "AAA"));
        assertTrue(map.insert("BBB", "BBB"));
        assertTrue(map.insert("CCC", "CCC"));
        assertTrue(map.insert("DDD", "DDD"));
        assertTrue(map.insert("EEE", "EEE"));
        assertTrue(map.insert("FFF", "FFF"));
        assertTrue(map.insert("GGG", "GGG"));
        assertTrue(map.insert("HHH", "HHH"));
        assertTrue(map.insert("III", "III"));
        assertTrue(map.insert("JJJ", "JJJ"));
        assertTrue(map.insert("KKK", "KKK"));
        assertTrue(map.insert("LLL", "LLL"));
        assertTrue(map.insert("MMM", "MMM"));
        assertTrue(map.insert("NNN", "NNN"));
        assertTrue(map.insert("OOO", "OOO"));
        assertTrue(map.insert("PPP", "PPP"));
        assertTrue(map.insert("QQQ", "QQQ"));
        assertThat(map.size(), is(18));
    }

    @Test(expected = IllegalArgumentException.class)
    public void mapTestFive() {
        new HashMap<String, String>(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mapTestSix() {
        new HashMap<String, String>(1.5F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mapTestSeven() {
        new HashMap<String, String>(-1.5F);
    }

    @Test
    public void mapTestEight() {
        assertTrue(map.insert(null, null));
        assertTrue(map.insert("AAA", "AAA"));
        assertTrue(map.insert("BBB", "BBB"));
        assertTrue(map.insert("CCC", "CCC"));
        assertThat(map.get("FFF"), nullValue());
        assertFalse(map.delete("GGG"));
    }

    @Test
    public void mapIteratorTestOne() {
        map.insert(null, null);
        map.insert("QQQ", "QQQ");
        map.insert("ZZZ", "ZZZ");
        map.insert("SSS", "SSS");
        map.insert("WWW", "WWW");
        map.insert("UUU", "UUU");
        map.insert("FFF", "FFF");
        map.insert("GGG", "GGG");
        map.insert("HHH", "HHH");
        Iterator<HashMap.Entry<String, String>> iterator = map.iterator();
        HashMap.Entry<String, String> value = iterator.next();
        assertThat(value.key, nullValue());
        assertThat(value.value, nullValue());
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertThat(value.key, is("QQQ"));
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertThat(value.key, is("SSS"));
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertThat(value.key, is("UUU"));
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertThat(value.key, is("FFF"));
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertThat(value.key, is("WWW"));
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertThat(value.key, is("HHH"));
        assertTrue(iterator.hasNext());
        value = iterator.next();
        assertThat(value.key, is("ZZZ"));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void mapIteratorTestTwo() {
        map.insert(null, null);
        map.insert("QQQ", "QQQ");
        map.insert("ZZZ", "ZZZ");
        map.insert("SSS", "SSS");
        Iterator<HashMap.Entry<String, String>> iterator = map.iterator();
        HashMap.Entry<String, String> value = iterator.next();
        map.insert("HHH", "HHH");
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void mapIteratorTestThree() {
        map.insert(null, null);
        map.insert("QQQ", "QQQ");
        map.insert("ZZZ", "ZZZ");
        map.insert("SSS", "SSS");
        Iterator<HashMap.Entry<String, String>> iterator = map.iterator();
        iterator.next();
        map.delete(null);
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void mapIteratorTestFour() {
        map.insert(null, null);
        map.insert("QQQ", "QQQ");
        map.insert("ZZZ", "ZZZ");
        map.insert("SSS", "SSS");
        Iterator<HashMap.Entry<String, String>> iterator = map.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }


}