package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты к классу Config.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/appIOTest.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
        assertThat(
                config.value("contry"),
                is("Russia")
        );
        assertThat(
                config.value("city"),
                is("Omsk")
        );
        assertThat(
                config.value("code"),
                is("Java")
        );
    }
}
