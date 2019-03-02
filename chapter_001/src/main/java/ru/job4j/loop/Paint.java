package ru.job4j.loop;

/**
 * Реализация пирамиды в псевдографике.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class Paint {

    /**
     * Метод построения правой полупирамиды.
     *
     * @param height int высота полупирамиды в строках.
     * @return String правая полупирамида.
     */
    public String rightTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Метод построения левой полупирамиды.
     *
     * @param height int высота полупирамиды в строках.
     * @return String полупирамида.
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= width - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Метод строит пирамиду в псевдографике.
     *
     * @param height int высота пирамиды в строках.
     * @return String пирамида.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
