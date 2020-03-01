package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Тесты к консольному чату.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ChatTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void chatTestOne() throws IOException {
        String[] dbArray = new String[]{"Hello", "Привет", "Мир", "Java", "Get", "Set",
                "Delete", "Strings", "World", "Computer", "Notebook", "Music", "Пока",
                "Movies", "HeadPhone", "Random", "Access"};
        File log = data("log.txt");
        Chat chat = new Chat(data("database.txt", dbArray)
                , log);

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
            }
        }
        return patch;
    }

}