package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 25.02.19.
 */
public class DummyBotTest {
    @Test
    public void answertTestOne() {
        DummyBot bot = new DummyBot();
        String result = bot.answert("Привет Бот.");
        String expect = "Привет, умник.";
        assertEquals(result, expect);
    }

    @Test
    public void answertTestTwo() {
        DummyBot bot = new DummyBot();
        String result = bot.answert("Пока.");
        String expect = "До скорой встречи.";
        assertEquals(result, expect);
    }

    @Test
    public void answertTestThree() {
        DummyBot bot = new DummyBot();
        String result = bot.answert("Здравствуйте");
        String expect = "Это ставит меня в тупик,задайте другой вопрос.";
        assertEquals(result, expect);
    }

}
