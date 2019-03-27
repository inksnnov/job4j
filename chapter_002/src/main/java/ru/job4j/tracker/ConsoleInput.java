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
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
