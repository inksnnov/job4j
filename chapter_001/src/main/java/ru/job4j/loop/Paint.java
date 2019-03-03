package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Реализация пирамиды в псевдографике.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class Paint {

    /**
     * Метод реализует проверку в пирамиде где нужно поставить галку.
     *
     * @param height  int высота.
     * @param widht   int ширина.
     * @param predict условие проставления галки.
     * @return String.
     */
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
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
     * Метод построения правой полупирамиды.
     *
     * @param height int высота в строках.
     * @return String полупирамида.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Метод построения левой полупирамиды.
     *
     * @param height int высота полупирамиды в строках.
     * @return String полупирамида.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Метод строит пирамиду в псевдографике.
     *
     * @param height int высота пирамиды в строках.
     * @return String пирамида.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
}
