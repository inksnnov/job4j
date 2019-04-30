package ru.job4j.chess;

/**
 * Ислючение предназначено для выброса при попытке не верного хода фигурой.
 *
 * @author Alexandr Khomichevskiy.
 */

public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException() {
    }

    public ImpossibleMoveException(String message) {
        super(message);
    }
}
