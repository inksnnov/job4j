package ru.job4j.total;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


/**
 * Тесты к классу Analyze.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class AnalyzeTest {
    private Analyze analyze = new Analyze();

    @Test
    public void analyzeTestOne() {
        List<Analyze.User> oldUser = Arrays.asList(
                new Analyze.User(1, "AAA"),
                new Analyze.User(2, "BBB"),
                new Analyze.User(3, "CCC"),
                new Analyze.User(4, "DDD"),
                new Analyze.User(5, "EEE"));
        List<Analyze.User> newUser = Arrays.asList(
                new Analyze.User(3, "ZZZ"),
                new Analyze.User(4, "DDD"),
                new Analyze.User(5, "EEE"),
                new Analyze.User(6, "FFF"));
        Analyze.Info info = analyze.diff(oldUser, newUser);
        assertThat(info.changed, is(1));
        assertThat(info.added, is(1));
        assertThat(info.deleted, is(2));
    }

    @Test
    public void analyzeTestTwo() {
        List<Analyze.User> oldUser = Arrays.asList(
                new Analyze.User(1, "AAA"),
                new Analyze.User(2, "BBB"),
                new Analyze.User(3, "CCC"),
                new Analyze.User(4, "DDD"),
                new Analyze.User(5, "EEE"));
        List<Analyze.User> newUser = Arrays.asList(
                new Analyze.User(3, "ZZZ"),
                new Analyze.User(5, "EEE"),
                new Analyze.User(6, "FFF"));
        Analyze.Info info = analyze.diff(oldUser, newUser);
        assertThat(info.changed, is(1));
        assertThat(info.added, is(1));
        assertThat(info.deleted, is(3));
    }

    @Test
    public void analyzeTestTree() {
        List<Analyze.User> oldUser = Arrays.asList(
                new Analyze.User(1, "AAA"),
                new Analyze.User(2, "BBB"),
                new Analyze.User(3, "CCC"),
                new Analyze.User(4, "DDD"),
                new Analyze.User(5, "EEE"));
        List<Analyze.User> newUser = Arrays.asList(
                new Analyze.User(1, "AAA"),
                new Analyze.User(2, "BBB"),
                new Analyze.User(3, "CCC"),
                new Analyze.User(4, "DDD"),
                new Analyze.User(5, "EEE"));
        Analyze.Info info = analyze.diff(oldUser, newUser);
        assertThat(info.changed, is(0));
        assertThat(info.added, is(0));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void analyzeTestFour() {
        List<Analyze.User> oldUser = Arrays.asList(
                new Analyze.User(1, "AAA"),
                new Analyze.User(2, "BBB"),
                new Analyze.User(3, "CCC"),
                new Analyze.User(4, "DDD"),
                new Analyze.User(5, "EEE"));
        List<Analyze.User> newUser = Arrays.asList(
                new Analyze.User(2, "DDD"),
                new Analyze.User(4, "CCC"),
                new Analyze.User(6, "AAA"),
                new Analyze.User(1, "EEE"),
                new Analyze.User(7, "BBB"));
        Analyze.Info info = analyze.diff(oldUser, newUser);
        assertThat(info.changed, is(3));
        assertThat(info.added, is(2));
        assertThat(info.deleted, is(2));
    }

    @Test
    public void analyzeTestFive() {
        List<Analyze.User> oldUser = Arrays.asList(
                new Analyze.User(1, "AAA"),
                new Analyze.User(2, "BBB"),
                new Analyze.User(3, "CCC"),
                new Analyze.User(4, "DDD"),
                new Analyze.User(5, "EEE"));
        List<Analyze.User> newUser = Arrays.asList(
                new Analyze.User(5, "AAA"),
                new Analyze.User(4, "DDD"),
                new Analyze.User(3, "DDD"),
                new Analyze.User(2, "BBB"),
                new Analyze.User(1, "AAA"));
        Analyze.Info info = analyze.diff(oldUser, newUser);
        assertThat(info.changed, is(2));
        assertThat(info.added, is(0));
        assertThat(info.deleted, is(0));
    }
}