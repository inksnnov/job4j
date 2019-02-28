package ru.job4j.loop;

/**
 * Построение шахматной доски.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 * @since 28.02.19.
 */
public class Board {

    /**
     * Метод реализует шахматную доску с помощью StringBuilder.
     *
     * @param width  int ширина доски.
     * @param height int высота доски.
     * @return String шахматная доска.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
