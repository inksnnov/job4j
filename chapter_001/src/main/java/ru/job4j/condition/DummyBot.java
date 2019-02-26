package ru.job4j.condition;

/**
 * Simply bot.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 25.02.19.
 */
public class DummyBot {

    /**
     * Метод глупого бота.
     *
     * @param qwestion String - входящее сообщение.
     * @return String - ответ.
     */
    public String answert(String qwestion) {
        String result = "Это ставит меня в тупик,задайте другой вопрос.";
        if (qwestion.equals("Привет Бот.")) {
            result = "Привет, умник.";
        } else if (qwestion.equals("Пока.")) {
            result = "До скорой встречи.";
        }
        return result;
    }
}
