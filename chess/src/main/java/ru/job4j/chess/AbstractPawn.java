package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Абстрактный класс содержащий метод-реализацию фигуры пешка.
 *
 * @author Alexandr Khomichevskiy.
 */
public class AbstractPawn implements Figure {

    @Override
    public Cell position() {
        return null;
    }

    /**
     * Метод поведения фигуры пешка.
     * Проверяем, если идет на одну клетку по оси Y(вертикаль)
     * возвращаем ход, иначе ImpossibleMoveException.
     * В зависимости от цвета фигуры delta меняеться
     * Черная пешка -1, ходим вверх по оси Y.
     * Белая пешка 1, ходим вниз по оси Y.
     *
     * @param source Cell позиция до хода.
     * @param dest   Cell клетка куда пытаемся сходить.
     * @return Cell[] массив ходов поклеточно, без source.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int delta = this.getClass().getSimpleName().contains("PawnBlack") ? -1 : 1;
        if (!(source.y + delta == dest.y && source.x == dest.x)) {
            throw new ImpossibleMoveException("Неверный ход!");
        }
        return new Cell[]{dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return null;
    }
}
