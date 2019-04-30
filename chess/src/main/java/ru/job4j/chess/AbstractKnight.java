package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Абстрактный класс содержащий метод-реализацию фигуры конь.
 *
 * @author Alexandr Khomichevskiy.
 */
public class AbstractKnight implements Figure {

    @Override
    public Cell position() {
        return null;
    }

    /**
     * Метод поведения фигуры конь.
     * Вычисляем какая ось от source до dest длинее.
     * Вычисляем длинну массива steps для записи шагов.
     * Создаем массив steps.
     * Инициализируем переменные.
     * В цикле делаем два хода по длинной оси в зависимости в какую сторону идем, если true по x, false y.
     * В переменные lastStepX и lastStepY записивыем знаения последнего хода в зависимости от направления
     * вектора бокового шага.
     * Делаем последний ход исходя из длинны наибольшей оси.
     * Проверка на равенство, если позиция куда мы хотим сходить не равна тому, что мы получили в методе и
     * длинна шагов не равна трем, выкидываем ImpossibleMoveException.
     * Иначе возвращаем массив шагов steps[].
     *
     * @param source Cell позиция до хода.
     * @param dest   Cell клетка куда пытаемся сходить.
     * @return Cell[] массив ходов поклеточно, без source.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[3];
        int deltaX = 0, deltaY = 0, x = 0, y = 0;
        int lastStepX = source.x < dest.x ? 1 : -1;
        int lastStepY = source.y < dest.y ? 1 : -1;
        boolean logicDelta = Math.abs(dest.x - source.x) > Math.abs(dest.y - source.y);
        for (int i = 0; i < steps.length; i++) {
            if (i == steps.length - 1) {
                steps[i] = logicDelta ? Cell.findCell(x, source.y + lastStepY) : Cell.findCell(source.x + lastStepX, y);
                break;
            } else if (logicDelta) {
                x = source.x > dest.x ? --deltaX + source.x : ++deltaX + source.x;
                steps[i] = Cell.findCell(x, source.y);
            } else {
                y = source.y > dest.y ? --deltaY + source.y : ++deltaY + source.y;
                steps[i] = Cell.findCell(source.x, y);
            }
        }
        if (!steps[steps.length - 1].equals(dest)) {
            throw new ImpossibleMoveException("Неверный ход!");
        }
        return steps;
    }


    @Override
    public Figure copy(Cell dest) {
        return null;
    }
}
