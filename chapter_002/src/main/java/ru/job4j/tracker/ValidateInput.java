package ru.job4j.tracker;

/**
 * Класс пользовательского ввода с обработкой исключений.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Переопределенный метод пользовательского ввода с обработкой исключений
     * при неверном вводе.
     *
     * @param question String Вопрос пользователю.
     * @param range    int[]  массив элементов меню.
     * @return int выбранный пользователем ключ меню.
     */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введите пункт меню из диапазона значений.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректное числовое значение.");
            }
        } while (invalid);
        return value;
    }
}
