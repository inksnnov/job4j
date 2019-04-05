package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс пользовательского ввода.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ConsoleInput implements Input {

    /**
     * Создаем объект ввода с консоли.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Главный метод - принимает значения из консоли, задает пользователю вопросы.
     *
     * @param question String задать вопрос перед вводом.
     * @return String ввод пользователя.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Перегруженный метод ask.
     *
     * @param question String вопрос пользователю.
     * @param range    int []передаем массив элементов меню.
     * @return int полученное значение пункта меню от пользователя.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Некорректный пункт меню, повторите ввод.");
        }
    }
}
