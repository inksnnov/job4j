package ru.job4j.pack;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Архиватор файлов.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Pack {
    /**
     * Путь архивации.
     */
    private Path sourcePath;
    /**
     * Путь целевого архива.
     */
    private Path output;
    /**
     * Расширения файлов которые не будут включены
     * в архив.
     */
    private final List<String> exclude = new ArrayList<>();

    /**
     * Точка входа в программу.
     *
     * @param args параметры командной строки.
     */
    public static void main(String[] args) {
        Pack pack = new Pack();
        pack.parseArgs(args);
        Zipper zipper = new Zipper(pack.sourcePath, pack.output, pack.predicate());
        zipper.start();
    }

    /**
     * Метод парсит переданные аргументы командной строки.
     * Аргументы расширений файлов могут передаваться пустыми,
     * тогда в архив включаются все файлы.
     * Метод проверяет, является ли каталогом и действующим
     * путь архивации.
     *
     * @param args аргументы командной строки.
     */
    private void parseArgs(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Please enter arguments.");
        }
        List<String> argument = new ArrayList<>(List.of(args));
        int d = argument.indexOf("-d");
        int e = argument.indexOf("-e");
        int o = argument.indexOf("-o");
        if (d == e) {
            throw new IllegalArgumentException("Invalid source path.");
        } else if (o == argument.size() - 1) {
            throw new IllegalArgumentException("Invalid output path");
        } else if (!Files.isDirectory(Paths.get(argument.get(d + 1)))
                && !Files.exists(Paths.get(argument.get(d + 1)))) {
            throw new IllegalArgumentException("No such folder");
        }
        sourcePath = Paths.get(argument.get(d + 1));
        exclude.addAll(argument.subList(e + 1, o));
        output = Paths.get(argument.get(argument.size() - 1));
    }

    /**
     * Правило отбора файлов которые не будут включены
     * в архив.
     * Данный предикат проверяет конец имени файлов.
     *
     * @return Predicate<String>.
     */
    private Predicate<String> predicate() {
        return s -> {
            boolean result = true;
            if (exclude.size() != 0) {
                for (String ex : exclude) {
                    if (s.contains(ex)) {
                        result = false;
                        break;
                    }
                }
            }
            return result;
        };
    }
}
