package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Абстрактный класс содержащий метод-реализацию фигуры ладья.
 *
 * @author Alexandr Khomichevskiy.
 */
public class AbstractRook implements Figure {

    @Override
    public Cell position() {
        return null;
    }

    /**
     * Метод поведения фигуры ладья.
     * Проверяем что фигура ходит только в одной оси, если нет
     * выкидываем ImpossibleMoveException.
     * Вычисляем по какой оси движеться фигура, затем создаем массив шагов
     * размер которого будет равен длинне шагов без source по оси на которой
     * осуществляется движение.
     * Затем в зависимости от оси(logicDelta) в цикле считаем шаги по дельтам
     * и записываем в массив steps.
     *
     * @param source Cell позиция до хода.
     * @param dest   Cell клетка куда пытаемся сходить.
     * @return Cell[] массив ходов поклеточно, без source.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if ((source.x != dest.x) == (source.y != dest.y)) {
            throw new ImpossibleMoveException("Неверный ход!");
        }
        boolean logicDelta = source.x == dest.x;
        int stepSize = logicDelta ? Math.abs(source.y - dest.y) : Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[stepSize];
        int deltaX = 0, deltaY = 0;
        for (int i = 0; i < steps.length; i++) {
            if (logicDelta) {
                int y = source.y > dest.y ? --deltaY + source.y : ++deltaY + source.y;
                steps[i] = Cell.findCell(source.x, y);
            } else {
                int x = source.x > dest.x ? --deltaX + source.x : ++deltaX + source.x;
                steps[i] = Cell.findCell(x, source.y);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return null;
    }
}
