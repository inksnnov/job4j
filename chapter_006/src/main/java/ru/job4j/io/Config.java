package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Класс парсинга файла настроек.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Config {
    /**
     * Путь к файлу настроек.
     */
    private final String path;
    /**
     * Храним настройки как ключ и значение, разделенные "=".
     */
    private final Map<String, String> values = new HashMap<>();

    /**
     * При создании объекта указываем путь к файлу.
     *
     * @param path путь к файлу настроек.
     */
    public Config(final String path) {
        this.path = path;
    }

    /**
     * Метод парсинга файла настроек и сохранения в мапу.
     * Опускает строки с коментариями и пустые строки,
     * а так же строки только с одним ключем.
     * Пробелы по краям строк обрезаем.
     */
    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.lines().filter(str -> !str.startsWith("#") && str.contains("="))
                    .map(str -> str.split("="))
                    .filter(str -> str.length == 2)
                    .forEach(str -> values.put(str[0].trim(), str[1].trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получем значение настройки по ключу.
     *
     * @param key ключ настройки.
     * @return значение настройки.
     */
    public String value(String key) {
        return values.get(key);
    }

    /**
     * Переопределенный метод toString для вывода
     * файла настройки строкой.
     *
     * @return файл настройки в строковом предаставлении.
     */
    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}