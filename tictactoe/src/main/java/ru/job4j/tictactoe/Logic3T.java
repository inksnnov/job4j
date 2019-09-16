package ru.job4j.tictactoe;

import java.util.Arrays;

/**
 * Класс реализует методы проверки ходов
 * в игре крестики-нолики.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Logic3T {

    /**
     * Матрица хранит ходы крестиков-ноликов.
     */
    private final Figure3T[][] table;

    /**
     * Инициализируем таблицу table.
     *
     * @param table
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Метод проверяет ходы фигур на матрице table
     * согласно переданному условию int...way 0 ячейка не проверяеться,
     * 1 ячейка проверяеться.
     *
     * @param mark true проверяем ходы крестиков, false ноликов.
     * @param way  условие проверки.
     * @return результат проверки.
     */
    private boolean logic(boolean mark, int... way) {
        var result = Arrays.stream(this.table)
                .flatMap(Arrays::stream)
                .filter(x -> {
                    var i = 0;
                    return mark ? x.hasMarkX() && way[i++] == 1 : x.hasMarkO() && way[i++] == 1;
                })
                .count();
        return result == this.table.length;
    }

    /**
     * Заданные условия для проверки ходов, проверяет по всем плоскостям и по диагонали.
     *
     * @param mark true проверяем ходы крестиков, false ноликов.
     * @return результат проверки.
     */
    private boolean ways(boolean mark) {
        var result = false;
        if (this.logic(mark, 1, 1, 1, 0, 0, 0, 0, 0, 0)
                || this.logic(mark, 0, 0, 0, 1, 1, 1, 0, 0, 0)
                || this.logic(mark, 0, 0, 0, 0, 0, 0, 1, 1, 1)
                || this.logic(mark, 1, 0, 0, 1, 0, 0, 1, 0, 0)
                || this.logic(mark, 0, 1, 0, 0, 1, 0, 0, 1, 0)
                || this.logic(mark, 0, 0, 1, 0, 0, 1, 0, 0, 1)
                || this.logic(mark, 1, 0, 0, 0, 1, 0, 0, 0, 1)
                || this.logic(mark, 0, 0, 1, 0, 1, 0, 1, 0, 0)
        ) {
            result = true;
        }
        return result;
    }

    /**
     * Метод проверки выйгрышных комбинаций крестиков.
     *
     * @return результат проверки.
     */
    public boolean isWinnerX() {
        return ways(true);
    }

    /**
     * Метод проверки выйгрышных комбинаций крестиков.
     *
     * @return результат проверки.
     */
    public boolean isWinnerO() {
        return ways(false);
    }

    /**
     * Метод проверяет остались ли еще свободные для хода пустые ячейки.
     *
     * @return результат проверки.
     */
    public boolean hasGap() {
        return Arrays.stream(this.table)
                .flatMap(Arrays::stream)
                .anyMatch(x -> !x.hasMarkO() || !x.hasMarkX());
    }
}
