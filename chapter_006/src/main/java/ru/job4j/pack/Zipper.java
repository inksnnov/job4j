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
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Zipper {
    private final Path sourcePath;
    private final Path output;
    private final Predicate<String> predicate;

    public Zipper(Path sourcePath, Path output, Predicate<String> predicate) {
        this.sourcePath = sourcePath;
        this.output = output;
        this.predicate = predicate;
    }

    public void start() {
        zip(getPath(sourcePath, predicate), output);
    }

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