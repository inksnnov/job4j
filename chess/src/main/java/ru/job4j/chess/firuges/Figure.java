package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

/**
 * Интерфейс - реализация фигуры.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */

public interface Figure {
    /**
     * Метод возвращает позицию фигуры на доске.
     *
     * @return Cell позиция.
     */
    Cell position();

    /**
     * Метод определяет возможность хода фигурой,
     * если фигура так не ходит выкидываем ImpossibleMoveException.
     *
     * @param source Cell позиция до хода.
     * @param dest   Cell позиция куда пытаемся сходить.
     * @return Cell[] возвращаем массив ходов без source.
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * Дефолтная реализация метода задающего каждой фигуре изображение
     * соответсвующее данной фигуре.
     *
     * @return String имя файла изображения фигуры.
     */
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    /**
     * Создаем новую копию фигуры если ход верен.
     *
     * @param dest Cell куда сходили.
     * @return  Figure копия объекта данной фигуры.
     */
    Figure copy(Cell dest);

}
