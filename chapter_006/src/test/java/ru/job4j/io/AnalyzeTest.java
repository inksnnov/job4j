package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Тесты к классу Analyze.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class AnalyzeTest {
    String ln = System.lineSeparator();
    Analyze analyze = new Analyze();

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void analyzeTestOne() throws IOException {
        File log = data(
                "server.log",
                "200 10:56:01",
                "500 10:57:01",
                "400 10:58:01",
                "200 10:59:01",
                "500 11:01:02",
                "200 11:02:02");
        File result = data("output.log", "");
        analyze.writeResult(analyze.unavailable(log), result);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(result))) {
            reader.lines().forEach(
                    str -> content.append(str).append(ln)
            );
        }
        assertThat(content.toString(), is(
                "10:57:01;10:59:01" + ln
                        + "11:01:02;11:02:02" + ln
        ));
    }

    @Test
    public void analyzeTestTwo() throws IOException {
        File log = data(
                "serverTwo.log",
                "200 10:56:01", ln,
                "500 10:57:01", ln,
                "400 10:58:01", ln,
                "200 10:59:01", ln,
                "500 11:01:02", ln,
                "200 11:02:02");
        File result = data("outputTwo.log", "");
        analyze.writeResult(analyze.unavailable(log), result);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(result))) {
            reader.lines().forEach(
                    str -> content.append(str).append(ln)
            );
        }
        assertThat(content.toString(), is(
                "10:57:01;10:59:01" + ln
                        + "11:01:02;11:02:02" + ln
        ));
    }

    @Test
    public void analyzeTestThree() throws IOException {
        File log = data(
                "serverThree.log",
                "200 10:56:01", ln,
                "500 10:57:01", ln,
                "400 10:58:01", ln,
                "200 10:59:01", ln,
                "500 11:01:02", ln
        );
        File result = data("outputThree.log", "");
        analyze.writeResult(analyze.unavailable(log), result);
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(result))) {
            reader.lines().forEach(
                    str -> content.append(str).append(ln)
            );
        }
        assertThat(content.toString(), is(
                "10:57:01;10:59:01" + ln
        ));
    }

    private File data(String file, String... properties) throws IOException {
        File patch = temporaryFolder.newFile(file);
        if (!patch.exists()) {
            throw new IllegalStateException(
                    String.format("File could not create %s", patch.getAbsolutePath())
            );
        }
        if (properties.length != 0) {
            try (PrintWriter store = new PrintWriter(patch)) {
                Stream.of(properties).forEach(store::println);
                store.flush();
            }
        }
        return patch;
    }
}