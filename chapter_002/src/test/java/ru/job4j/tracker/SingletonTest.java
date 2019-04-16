package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SingletonTest {

    @Test
    public void singleEagerTestOne() {
        SingleEagerOne single = SingleEagerOne.getInstance();
        assertEquals(single.getTracker(), single.getTracker());
    }

    @Test
    public void singleEagerTestTwo() {
        SingleEagerTwo single = SingleEagerTwo.INSTANCE;
        assertEquals(single.getTracker(), single.getTracker());
    }

    @Test
    public void singleLazyTestOne() {
        SingleLazyOne single = SingleLazyOne.getInstance();
        assertEquals(single.getTracker(), single.getTracker());
    }

    @Test
    public void singleLazyTestTwo() {
        SingleLazyTwo single = SingleLazyTwo.getInstance();
        assertEquals(single.getTracker(), single.getTracker());
    }


}
