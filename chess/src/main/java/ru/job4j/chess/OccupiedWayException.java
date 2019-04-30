package ru.job4j.chess;

/**
 * Ислючение предназначено для выброса при попытке хода фигурой по занятам клеткам.
 *
 * @author Alexandr Khomichevskiy.
 */

public class OccupiedWayException extends RuntimeException {

    public OccupiedWayException() {
    }

    public OccupiedWayException(String message) {
        super(message);
    }
}
