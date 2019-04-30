package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Абстрактный класс содержащий метод-реализацию фигуры королева.
 *
 * @author Alexandr Khomichevskiy.
 */
public class AbstractQueen implements Figure {

    @Override
    public Cell position() {
        return null;
    }

    /**
     * Метод реализует поведение фигуры королева.
     * Логика метода состоит из логик двух фигур - слон и ладья.
     * Инициализируем массов steps для записи шагов.
     * Проверяем, если фигура идет по диагонали - применяем логику фигуры ладья.
     * Если ладьей не ходим, проверяем, что если одна из координат совпадает с конечной, значит
     * применяем логику фигуры слон.
     * Если совпадений нет выкидываем ImpossibleMoveException.
     *
     * @param source Cell позиция до хода.
     * @param dest   Cell позиция куда пытаемся сходить.
     * @return возвращаем массив шагов.
     * @throws ImpossibleMoveException выкидываем в случае не совпадения одной из логик ходов.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps;
        if ((Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y))) {
            steps = new Cell[Math.abs(dest.x - source.x)];
            int deltaX = 0, deltaY = 0;
            for (int i = 0; i < steps.length; i++) {
                int x = source.x > dest.x ? --deltaX + source.x : ++deltaX + source.x;
                int y = source.y > dest.y ? --deltaY + source.y : ++deltaY + source.y;
                steps[i] = Cell.findCell(x, y);
            }
        } else if ((source.x == dest.x) || (source.y == dest.y)) {
            boolean logicDelta = source.x == dest.x;
            int stepSize = logicDelta ? Math.abs(source.y - dest.y) : Math.abs(source.x - dest.x);
            steps = new Cell[stepSize];
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
        } else {
            throw new ImpossibleMoveException("Неверный ход!");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return null;
    }
}
