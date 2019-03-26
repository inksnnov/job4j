package ru.job4j.tracker;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
class FormatOut {

    /**
     * Вывод в консоль имени и описания заявки в форматированном виде.
     *
     * @param name item.getName().
     * @param desc item.getDesc().
     */
    void format(String name, String desc) {
        String ln = System.lineSeparator();
        System.out.printf("%s %s %s", "Имя заявки : ", name, ln);
        System.out.printf("%s %s %s %s %s", "Описание заявки :", ln, desc, ln, ln);
    }
}
