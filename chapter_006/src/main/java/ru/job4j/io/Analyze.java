package ru.job4j.io;

import java.io.*;

/**
 * Реализуем анализ доступности сервера.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Analyze {

    /**
     * Анализ доступности сервера,
     * записывает диапазон 400 или 500 по 200 или 300.
     * Если не находит 200 или 300 после 400 или 500,
     * пару не записывает.
     *
     * @param in  Входной файл для анализа.
     * @param out Результат анализа.
     */
    public void unavailable(File in, File out) {
        boolean cursor = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(in));
             PrintWriter writer = new PrintWriter(new FileWriter(out), true)) {
            String str = reader.readLine();
            String tmp = "";
            while (str != null) {
                if (cursor && (str.startsWith("400") || str.startsWith("500"))) {
                    cursor = false;
                    tmp = str.substring(4);
                }
                if (!cursor && (str.startsWith("200") || str.startsWith("300"))) {
                    cursor = true;
                    writer.println(tmp.strip() + ";" + str.substring(4).strip());
                }
                str = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
