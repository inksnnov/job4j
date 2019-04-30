package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Абстрактный класс содержащий метод-реализацию фигуры король.
 *
 * @author Alexandr Khomichevskiy.
 */
public class AbstractKing implements Figure {

    @Override
    public Cell position() {
        return null;
    }

    /**
     * Метод поведения фигуры короля.
     * Заполняем дельты на основании того куда ходит фигура,
     * проверяем если ход на одну клетку в любую сторону возвращаем массив ходов,
     * иначе выбрасываем ImpossibleMoveException.
     *
     * @param source Cell позиция до хода.
     * @param dest   Cell клетка куда пытаемся сходить.
     * @return Cell[] массив ходов поклеточно, без source.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int deltaX = 0;
        int deltaY = 0;
        if (source.x != dest.x) {
            deltaX = source.x > dest.x ? -1 : 1;
        }
        if (source.y != dest.y) {
            deltaY = source.y > dest.y ? -1 : 1;
        }
        if (!(source.x + deltaX == dest.x && source.y + deltaY == dest.y)) {
            throw new ImpossibleMoveException("Неверный ход!");
        }
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return null;
    }
}
