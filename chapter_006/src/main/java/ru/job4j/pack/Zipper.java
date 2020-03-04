package ru.job4j.pack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Архиватор файлов, служебный класс.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Zipper {
    /**
     * Путь архивации.
     */
    private final Path sourcePath;
    /**
     * Путь к целевому архиву.
     */
    private final Path output;
    /**
     * Расширения файлов которые не будут
     * включены в архив.
     */
    private final Predicate<String> predicate;

    /**
     * Принимаем отпарсенные аргументы командной строки.
     *
     * @param sourcePath путь архивации.
     * @param output     путь целевого архива.
     * @param predicate  правило выбора файлов.
     */
    public Zipper(Path sourcePath, Path output, Predicate<String> predicate) {
        this.sourcePath = sourcePath;
        this.output = output;
        this.predicate = predicate;
    }

    /**
     * Точка входа в программу.
     */
    public void start() {
        zip(getPath(sourcePath, predicate), output);
    }

    /**
     * Проходим по директориям архивируемого каталога
     * используя предикат.
     *
     * @param path      путь архивации.
     * @param predicate правило исключения.
     * @return список путей файлов для архивации.
     */
    private List<Path> getPath(Path path, Predicate<String> predicate) {
        List<Path> result = new ArrayList<>();
        try (Stream<Path> pathStream = Files.walk(path)) {
            result = pathStream.filter(Files::isRegularFile)
                    .filter(pt -> predicate.test(pt.toString()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Упаковываем файлы в архив.
     *
     * @param source список файлов для упаковки.
     * @param output целевой архив.
     */
    private void zip(List<Path> source, Path output) {
        try (ZipOutputStream zos = new ZipOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(output.toString())))) {
            for (Path get : source) {
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(get.toString()))) {
                    Path inner = sourcePath.relativize(get);
                    ZipEntry zipEntry = new ZipEntry(inner.toString());
                    zos.putNextEntry(zipEntry);
                    byte[] buffer = new byte[4096];
                    int len;
                    while ((len = in.read(buffer)) != -1) {
                        zos.write(buffer, 0, len);
                    }
                } finally {
                    zos.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}