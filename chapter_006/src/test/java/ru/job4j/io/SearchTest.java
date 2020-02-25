package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Тесты к классу Search.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SearchTest {
    String fs = File.separator;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder(new File(System.getProperty("java.io.tmpdir")));

    @Test
    public void searchTestOne() throws IOException {
        File root = loadStructure();
        List<File> result = new Search().files(
                root.getAbsolutePath(),
                str -> str.endsWith("xml")
        );
        assertTrue(result.stream().allMatch(file -> file.getName().endsWith("xml")));
        assertEquals(3, result.size());
    }

    @Test
    public void searchTestTwo() throws IOException {
        File root = loadStructure();
        List<File> result = new Search().files(
                root.getAbsolutePath(),
                str -> str.endsWith("txt")
        );
        assertTrue(result.stream().allMatch(file -> file.getName().endsWith("txt")));
        assertEquals(1, result.size());
    }

    @Test
    public void searchTestThree() throws IOException {
        File root = loadStructure();
        List<File> result = new Search().files(
                root.getAbsolutePath(),
                str -> str.endsWith("txt") || str.endsWith("log")
        );
        assertTrue(
                result.stream()
                        .map(File::getName)
                        .allMatch(name -> name.endsWith("log")
                                || name.endsWith("txt")));
        assertEquals(2, result.size());
    }

    private File loadStructure() throws IOException {
        File root = temporaryFolder.newFolder();
        String path = root.getPath();
        if (!(new File(root, "test.xml").createNewFile()
                && new File(path + fs + "set").mkdir()
                && new File(path + fs + "set", "tree.xml").createNewFile()
                && new File(path + fs + "get").mkdir()
                && new File(path + fs + "get", "server.log").createNewFile()
                && new File(path + fs + "get" + fs + "test").mkdir()
                && new File(path + fs + "get" + fs + "test", "config.txt").createNewFile()
                && new File(path + fs + "get" + fs + "test", "settings.xml").createNewFile()
                && new File(path + fs + "get", "index.html").createNewFile()
        )) {
            throw new IllegalStateException("Files and directory not created" + root.getAbsolutePath());
        }
        return root;
    }

}