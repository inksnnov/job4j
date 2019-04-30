package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Абстрактный класс содержащий метод-реализацию фигуры слона.
 *
 * @author Alexandr Khomichevskiy.
 */
public class AbstractBishop implements Figure {

    @Override
    public Cell position() {
        return null;
    }

    /**
     * Метод поведения фигуры слона.
     * Проверяем что ход по диагонали, если нет
     * выкидываем ImpossibleMoveException.
     * Создаем массив шагов длиной он source до dest, исключая
     * source, в цикле вычисляем дельты направления хода,
     * записываем шаги с поправкой на дельты в массив steps[].
     *
     * @param source Cell позиция до хода.
     * @param dest   Cell клетка куда пытаемся сходить.
     * @return Cell[] массив ходов поклеточно, без source.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!(Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y))) {
            throw new ImpossibleMoveException("Неверный ход!");
        }
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
        int deltaX = 0, deltaY = 0;
        for (int i = 0; i < steps.length; i++) {
            int x = source.x > dest.x ? --deltaX + source.x : ++deltaX + source.x;
            int y = source.y > dest.y ? --deltaY + source.y : ++deltaY + source.y;
            steps[i] = Cell.findCell(x, y);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return null;
    }
}
