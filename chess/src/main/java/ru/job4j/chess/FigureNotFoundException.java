package ru.job4j.chess;

/**
 * @author Alexandr Khomichevskiy.
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException() {
    }

    public FigureNotFoundException(String message) {
        super(message);
    }
}
