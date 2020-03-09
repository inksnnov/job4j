package ru.job4j.pack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * Тесты к архиватору.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class PackTest {
    String ln = System.lineSeparator();
    File testFolder;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test(expected = IllegalArgumentException.class)
    public void testPackOne() {
        Pack.main(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPackTwo() {
        Pack.main(new String[]
                {"-d", System.getProperty("java.io.tmpdir") + System.currentTimeMillis(), "-e", "-o", "test.zip"});
    }

    @Test
    public void testPackThree() throws IOException {
        String str = null;
        testFolder = tempFolder.newFolder();
        File file = data("test.txt", "Test archiver, java IO.");
        File fileTwo = data("test.java", "Java file.");
        File result = new File(System.getProperty("java.io.tmpdir"), "test.zip");
        Pack.main(new String[]
                {"-d", testFolder.getAbsolutePath(), "-e", ".java", "-o", result.getAbsolutePath()});
        ZipInputStream zipFile = new ZipInputStream(new FileInputStream(result));
        ZipEntry entry;
        while ((entry = zipFile.getNextEntry()) != null) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bos.writeBytes(zipFile.readAllBytes());
            zipFile.closeEntry();
            str = new String(bos.toByteArray(), StandardCharsets.UTF_8);
        }
        zipFile.close();
        result.deleteOnExit();
        assertThat(str, is("Test archiver, java IO." + ln));
    }

    @Test
    public void testPackFour() throws IOException {
        String str = null;
        testFolder = tempFolder.newFolder();
        File file = data("test.txt", "Test archiver, java IO.");
        File fileTwo = data("test.xml", "Xml file.");
        File fileThree = data("test.java", "Java file.");
        File result = new File(System.getProperty("java.io.tmpdir"), "test.zip");
        Pack.main(new String[]
                {"-d", testFolder.getAbsolutePath(), "-e", ".xml", ".txt", "-o", result.getAbsolutePath()});
        ZipInputStream zipFile = new ZipInputStream(new FileInputStream(result));
        ZipEntry entry;
        while ((entry = zipFile.getNextEntry()) != null) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bos.writeBytes(zipFile.readAllBytes());
            zipFile.closeEntry();
            str = new String(bos.toByteArray(), StandardCharsets.UTF_8);
        }
        zipFile.close();
        result.deleteOnExit();
        assertThat(str, is("Java file." + ln));
    }

    private File data(String file, String... properties) throws IOException {
        File testFile = new File(testFolder, file);
        if (!testFile.createNewFile()) {
            throw new IllegalStateException(
                    String.format("File could not create %s", testFile.getAbsolutePath())
            );
        }
        PrintWriter writer = new PrintWriter(testFile);
        Stream.of(properties).forEach(writer::println);
        writer.close();
        return testFile;
    }
}