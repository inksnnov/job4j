package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 19.03.19.
 */
public class StartUITest {

    @Test
    public void createItemTestOne() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "testName", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("testName"));
    }

    @Test
    public void replaceItemTestOne() {
        Tracker tracker = new Tracker();
        long create = System.currentTimeMillis();
        Item itemOne = new Item("NameOne", "DescOne", create);
        Item itemTwo = new Item("NameTwo", "DescTwo", create);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        Input input = new StubInput(new String[]{"1", itemTwo.getId(), "NameThree", "DescThree", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("NameThree")[0].getName(), is("NameThree"));
    }

    @Test
    public void deleteItemOne() {
        Tracker tracker = new Tracker();
        long create = System.currentTimeMillis();
        Item itemOne = new Item("NameOne", "DescOne", create);
        Item itemTwo = new Item("NameTwo", "DescTwo", create);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        Input input = new StubInput(new String[]{"2", itemTwo.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(itemTwo.getId()));
    }


}
