package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Класс содежит методы для добавления фигур, передвижения, а так же
 * хранит фигуры.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {

    /**
     * Хранилище фигур.
     */
    private final Figure[] figures = new Figure[32];

    /**
     * Позиция в массиве figures для добавления фигур.
     */
    private int index = 0;

    /**
     * Добавляние фигур в массив figures.
     *
     * @param figure добавляемая фигура.
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Метод реализует перемещение фигуры на доске, исключая индивидуальную логику каждой фигуры.
     * Так же обрабатывает исключения ImpossibleMoveException и OccupiedWayException.
     *
     * @param source начальная позиция фигуры.
     * @param dest   желаемая позиция фигуры.
     * @return Если движение возможно true, иначе false.
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1 || this.figures[index] == null) {
            throw new FigureNotFoundException("Фигура не найдена!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        this.checkOccupiedWay(steps, dest, index);
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);

        }
        return rst;
    }

    /**
     * Очистка доски в массиве figures.
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * Метод поиска фигуры в массиве figures.
     *
     * @param cell ячейка.
     * @return позиция фигуры в массиве figures.
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Метод проверяет не занят ли путь фигуры другой фигурой, за исключением коня который
     * проверяеться только в последней клетке.
     *
     * @param steps массив шагов фигуры.
     * @param index указывает фигуру в массиве figures[index].
     */
    private void checkOccupiedWay(Cell[] steps, Cell dest, int index) throws OccupiedWayException {
        boolean knightFigure = this.figures[index].getClass().getSimpleName().contains("Knight");
        for (Cell cell : steps) {
            for (Figure figure : this.figures) {
                if (cell.equals(dest) && knightFigure && figure != null && cell.equals(figure.position())) {
                    throw new OccupiedWayException("Путь занят!");
                } else if (figure != null && cell.equals(figure.position()) && !knightFigure) {
                    throw new OccupiedWayException("Путь занят!");
                }
            }
        }
    }
}
