package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тесты к классу AbstractStore.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class StoreTest {

    private Store<User> store;

    @Before
    public void load() {
        store = new UserStore(10);
        store.add(new User("0001"));
        store.add(new User("0002"));
        store.add(new User("0003"));
        store.add(new User("0004"));
        store.add(new User("0005"));
        store.add(new User("0006"));
        store.add(new User("0007"));
        store.add(new User("0008"));
        store.add(new User("0009"));
        store.add(new User("0010"));
    }

    @Test(expected = ArrayStoreException.class)
    public void addTestOne() {
        store.add(new User("0011"));
    }

    @Test(expected = ArrayStoreException.class)
    public void addTestTwo() {
        store.add(new User("0001"));
    }

    @Test
    public void replaceTestOne() {
        User user = new User("1000");
        store.replace("0001", user);
        assertThat(store.findById("1000"), is(user));
    }

    @Test
    public void replaceTestTwo() {
        assertFalse(store.replace("0011", new User("1000")));
    }

    @Test
    public void deleteTestOne() {
        assertTrue(store.delete("0001"));
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteTestTwo() {
        store.delete("0001");
        store.findById("0001");
    }

    @Test
    public void deleteTestThree() {
        assertFalse(store.delete("0011"));
    }

    @Test
    public void findByIdTestOne() {
        assertThat(store.findById("0007"), is(new User("0007")));
    }

    @Test(expected = NoSuchElementException.class)
    public void findByIdTestTwo() {
        store.findById("0012");
    }
}
