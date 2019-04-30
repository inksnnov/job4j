package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

import static org.junit.Assert.*;

/**
 * Тесты не абстрактных методов проверки хода фигур из класса AbstractFigure.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class FigureLogicTest {

    @Test
    public void bishopWayTestOne() throws ImpossibleMoveException {
        Cell[] expect = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7, Cell.A8};
        Cell[] result = new BishopBlack(Cell.H1).way(Cell.H1, Cell.A8);
        assertArrayEquals(expect, result);
    }

    @Test
    public void bishopWayTestTwo() throws ImpossibleMoveException {
        Cell[] expect = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        Cell[] result = new BishopWhite(Cell.A1).way(Cell.A1, Cell.H8);
        assertArrayEquals(expect, result);
    }

    @Test
    public void bishopWayTestThree() throws ImpossibleMoveException {
        Cell[] expect = {Cell.D7, Cell.E6};
        Cell[] result = new BishopBlack(Cell.C8).way(Cell.C8, Cell.E6);
        assertArrayEquals(expect, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void bishopWayTestFour() throws ImpossibleMoveException {
        new BishopBlack(Cell.C7).way(Cell.C7, Cell.C1);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void bishopWayTestFive() throws ImpossibleMoveException {
        new BishopBlack(Cell.C1).way(Cell.C1, Cell.C7);
    }

    @Test
    public void rookWayTestOne() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A2, Cell.A3, Cell.A4, Cell.A5, Cell.A6, Cell.A7, Cell.A8};
        Cell[] result = new RookWhite(Cell.A1).way(Cell.A1, Cell.A8);
        assertArrayEquals(expect, result);
    }

    @Test
    public void rookWayTestTwo() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A7, Cell.A6, Cell.A5, Cell.A4, Cell.A3, Cell.A2};
        Cell[] result = new RookWhite(Cell.A8).way(Cell.A8, Cell.A2);
        assertArrayEquals(expect, result);
    }

    @Test
    public void rookWayTestThree() throws ImpossibleMoveException {
        Cell[] expect = {Cell.G2, Cell.F2, Cell.E2, Cell.D2};
        Cell[] result = new RookBlack(Cell.H2).way(Cell.H2, Cell.D2);
        assertArrayEquals(expect, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void rookWayTestFour() throws ImpossibleMoveException {
        new RookBlack(Cell.D4).way(Cell.D4, Cell.A3);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void rookWayTestFive() throws ImpossibleMoveException {
        new RookWhite(Cell.F6).way(Cell.F6, Cell.H7);
    }

    @Test
    public void pawnBlackWayTestOne() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A6};
        Cell[] result = new PawnBlack(Cell.A7).way(Cell.A7, Cell.A6);
        assertArrayEquals(expect, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnBlackWayTestTwo() throws ImpossibleMoveException {
        new PawnBlack(Cell.A7).way(Cell.A7, Cell.A8);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnBlackWayTestThree() throws ImpossibleMoveException {
        new PawnBlack(Cell.A7).way(Cell.A7, Cell.B7);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnBlackWayTestFour() throws ImpossibleMoveException {
        new PawnBlack(Cell.B7).way(Cell.B7, Cell.A6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnBlackWayTestFive() throws ImpossibleMoveException {
        new PawnBlack(Cell.A7).way(Cell.A7, Cell.A1);
    }

    @Test
    public void pawnWhiteWayTestOne() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A3};
        Cell[] result = new PawnWhite(Cell.A2).way(Cell.A2, Cell.A3);
        assertArrayEquals(expect, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnWhiteWayTestTwo() throws ImpossibleMoveException {
        new PawnWhite(Cell.G2).way(Cell.G2, Cell.G1);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnWhiteWayTestThree() throws ImpossibleMoveException {
        new PawnWhite(Cell.G2).way(Cell.G2, Cell.H2);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnWhiteWayTestFour() throws ImpossibleMoveException {
        new PawnWhite(Cell.A2).way(Cell.A2, Cell.G3);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void pawnWhiteWayTestFive() throws ImpossibleMoveException {
        new PawnWhite(Cell.A2).way(Cell.A2, Cell.A8);
    }

    @Test
    public void kingWayTestOne() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A2};
        Cell[] result = new KingBlack(Cell.A1).way(Cell.A1, Cell.A2);
        assertArrayEquals(expect, result);
    }

    @Test
    public void kingWayTestTwo() throws ImpossibleMoveException {
        Cell[] expect = {Cell.B1};
        Cell[] result = new KingBlack(Cell.A1).way(Cell.A1, Cell.B1);
        assertArrayEquals(expect, result);
    }

    @Test
    public void kingWayTestThree() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A5};
        Cell[] result = new KingWhite(Cell.A6).way(Cell.A6, Cell.A5);
        assertArrayEquals(expect, result);
    }

    @Test
    public void kingWayTestFour() throws ImpossibleMoveException {
        Cell[] expect = {Cell.C4};
        Cell[] result = new KingBlack(Cell.D4).way(Cell.D4, Cell.C4);
        assertArrayEquals(expect, result);
    }

    @Test
    public void kingWayTestFive() throws ImpossibleMoveException {
        Cell[] expect = {Cell.D6};
        Cell[] result = new KingWhite(Cell.E7).way(Cell.E7, Cell.D6);
        assertArrayEquals(expect, result);
    }

    @Test
    public void kingWayTestSix() throws ImpossibleMoveException {
        Cell[] expect = {Cell.F5};
        Cell[] result = new KingBlack(Cell.E4).way(Cell.E4, Cell.F5);
        assertArrayEquals(expect, result);
    }

    @Test
    public void kingWayTestSeven() throws ImpossibleMoveException {
        Cell[] expect = {Cell.C5};
        Cell[] result = new KingWhite(Cell.D4).way(Cell.D4, Cell.C5);
        assertArrayEquals(expect, result);
    }

    @Test
    public void kingWayTestEight() throws ImpossibleMoveException {
        Cell[] expect = {Cell.H6};
        Cell[] result = new KingBlack(Cell.G7).way(Cell.G7, Cell.H6);
        assertArrayEquals(expect, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void kingWayTestTen() throws ImpossibleMoveException {
        new KingWhite(Cell.A1).way(Cell.A1, Cell.A3);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void kingWayTestEleven() throws ImpossibleMoveException {
        new KingBlack(Cell.H8).way(Cell.H8, Cell.F7);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void kingWayTestTwelve() throws ImpossibleMoveException {
        new KingWhite(Cell.C4).way(Cell.C4, Cell.H4);
    }

    @Test
    public void knightWayTestOne() throws ImpossibleMoveException {
        Cell[] expect = {Cell.G1, Cell.F1, Cell.F2};
        Cell[] result = new KnightBlack(Cell.H1).way(Cell.H1, Cell.F2);
        assertArrayEquals(expect, result);
    }

    @Test
    public void knightWayTestTwo() throws ImpossibleMoveException {
        Cell[] expect = {Cell.B5, Cell.C5, Cell.C6};
        Cell[] result = new KnightWhite(Cell.A5).way(Cell.A5, Cell.C6);
        assertArrayEquals(expect, result);
    }

    @Test
    public void knightWayTestThree() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A7, Cell.A6, Cell.B6};
        Cell[] result = new KnightBlack(Cell.A8).way(Cell.A8, Cell.B6);
        assertArrayEquals(expect, result);
    }

    @Test
    public void knightWayTestFour() throws ImpossibleMoveException {
        Cell[] expect = {Cell.D4, Cell.C4, Cell.C3};
        Cell[] result = new KnightWhite(Cell.E4).way(Cell.E4, Cell.C3);
        assertArrayEquals(expect, result);
    }

    @Test
    public void knightWayTestFive() throws ImpossibleMoveException {
        Cell[] expect = {Cell.G3, Cell.G4, Cell.F4};
        Cell[] result = new KnightBlack(Cell.G2).way(Cell.G2, Cell.F4);
        assertArrayEquals(expect, result);
    }

    @Test
    public void knightWayTestSix() throws ImpossibleMoveException {
        Cell[] expect = {Cell.G6, Cell.G7, Cell.H7};
        Cell[] result = new KnightWhite(Cell.G5).way(Cell.G5, Cell.H7);
        assertArrayEquals(expect, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void knightWayTestSeven() throws ImpossibleMoveException {
        new KnightBlack(Cell.G5).way(Cell.G5, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void knightWayTestEight() throws ImpossibleMoveException {
        new KnightWhite(Cell.G5).way(Cell.G5, Cell.G8);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void knightWayTestNine() throws ImpossibleMoveException {
        new KnightBlack(Cell.B8).way(Cell.B8, Cell.C7);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void knightWayTestTen() throws ImpossibleMoveException {
        new KnightWhite(Cell.A1).way(Cell.A1, Cell.C3);
    }

    @Test
    public void queenWayTestOne() throws ImpossibleMoveException {
        Cell[] expect = {Cell.G2, Cell.F3, Cell.E4, Cell.D5, Cell.C6, Cell.B7, Cell.A8};
        Cell[] result = new QueenBlack(Cell.H1).way(Cell.H1, Cell.A8);
        assertArrayEquals(expect, result);
    }

    @Test
    public void queenWayTestTwo() throws ImpossibleMoveException {
        Cell[] expect = {Cell.B2, Cell.C3, Cell.D4, Cell.E5, Cell.F6, Cell.G7, Cell.H8};
        Cell[] result = new QueenWhite(Cell.A1).way(Cell.A1, Cell.H8);
        assertArrayEquals(expect, result);
    }

    @Test
    public void queenTestThree() throws ImpossibleMoveException {
        Cell[] expect = {Cell.D7, Cell.E6};
        Cell[] result = new QueenBlack(Cell.C8).way(Cell.C8, Cell.E6);
        assertArrayEquals(expect, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void queenWayTestFour() throws ImpossibleMoveException {
        new QueenWhite(Cell.C7).way(Cell.C7, Cell.G5);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void queenWayTestFive() throws ImpossibleMoveException {
        new QueenBlack(Cell.C1).way(Cell.G5, Cell.A1);
    }

    @Test
    public void queenWayTestSix() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A2, Cell.A3, Cell.A4, Cell.A5, Cell.A6, Cell.A7, Cell.A8};
        Cell[] result = new QueenWhite(Cell.A1).way(Cell.A1, Cell.A8);
        assertArrayEquals(expect, result);
    }

    @Test
    public void queenWayTestSeven() throws ImpossibleMoveException {
        Cell[] expect = {Cell.A7, Cell.A6, Cell.A5, Cell.A4, Cell.A3, Cell.A2};
        Cell[] result = new QueenBlack(Cell.A8).way(Cell.A8, Cell.A2);
        assertArrayEquals(expect, result);
    }

    @Test
    public void queenWayTestEight() throws ImpossibleMoveException {
        Cell[] expect = {Cell.G2, Cell.F2, Cell.E2, Cell.D2};
        Cell[] result = new QueenWhite(Cell.H2).way(Cell.H2, Cell.D2);
        assertArrayEquals(expect, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void queenWayTestNine() throws ImpossibleMoveException {
        new QueenBlack(Cell.D4).way(Cell.D4, Cell.A3);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void queenWayTestTen() throws ImpossibleMoveException {
        new QueenWhite(Cell.F6).way(Cell.F6, Cell.H7);
    }

}
