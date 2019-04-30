package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matcher.*;

/**
 * Тесты класса Logic.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class LogicTest {

    private Logic logic = new Logic();

    @Before
    public void initBoard() {
        this.logic.add(new PawnBlack(Cell.A7));
        this.logic.add(new PawnBlack(Cell.B7));
        this.logic.add(new PawnBlack(Cell.C7));
        this.logic.add(new PawnBlack(Cell.D7));
        this.logic.add(new PawnBlack(Cell.E7));
        this.logic.add(new PawnBlack(Cell.F7));
        this.logic.add(new PawnBlack(Cell.G7));
        this.logic.add(new PawnBlack(Cell.H7));
        this.logic.add(new RookBlack(Cell.A8));
        this.logic.add(new KnightBlack(Cell.B8));
        this.logic.add(new BishopBlack(Cell.C8));
        this.logic.add(new QueenBlack(Cell.D8));
        this.logic.add(new KingBlack(Cell.E8));
        this.logic.add(new BishopBlack(Cell.F8));
        this.logic.add(new KnightBlack(Cell.G8));
        this.logic.add(new RookBlack(Cell.H8));
        this.logic.add(new PawnWhite(Cell.A2));
        this.logic.add(new PawnWhite(Cell.B2));
        this.logic.add(new PawnWhite(Cell.C2));
        this.logic.add(new PawnWhite(Cell.D2));
        this.logic.add(new PawnWhite(Cell.E2));
        this.logic.add(new PawnWhite(Cell.F2));
        this.logic.add(new PawnWhite(Cell.G2));
        this.logic.add(new PawnWhite(Cell.H2));
        this.logic.add(new RookWhite(Cell.A1));
        this.logic.add(new KnightWhite(Cell.B1));
        this.logic.add(new BishopWhite(Cell.C1));
        this.logic.add(new QueenWhite(Cell.D1));
        this.logic.add(new KingWhite(Cell.E1));
        this.logic.add(new BishopWhite(Cell.F1));
        this.logic.add(new KnightWhite(Cell.G1));
        this.logic.add(new RookWhite(Cell.H1));
    }

    @Test
    public void moveTestOne() {
        assertThat(this.logic.move(Cell.E7, Cell.E6), is(true));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void moveTestTwo() {
        this.logic.move(Cell.F2, Cell.E3);
    }

    @Test(expected = OccupiedWayException.class)
    public void moveTestThree() {
        this.logic.move(Cell.A8, Cell.A4);
    }

    @Test(expected = OccupiedWayException.class)
    public void moveTestFour() {
        this.logic.move(Cell.E1, Cell.E2);
    }

    @Test
    public void moveTestFive() {
        assertThat(this.logic.move(Cell.G1, Cell.F3), is(true));
    }

    @Test
    public void moveTestSix() {
        assertThat(this.logic.move(Cell.B8, Cell.C6), is(true));
    }

    @Test(expected = OccupiedWayException.class)
    public void moveTestSeven() {
        this.logic.move(Cell.B1, Cell.D2);
    }

    @Test(expected = FigureNotFoundException.class)
    public void moveTestEight() {
        this.logic.clean();
        this.logic.move(Cell.D8, Cell.D4);
    }

}
