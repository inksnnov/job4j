package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

/**
 * Поиск в указанном каталоге и подкаталогах файлов по расширению.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Search {

    /**
     * Метод поиска файла по расширению,
     * алгоритм поиска в ширину.
     *
     * @param parent родительский каталог.
     * @param pr     предикат, для отборки по условию.
     * @return Список найденных файлов.
     */
    public List<File> files(String parent, Predicate<String> pr) {
        File root = new File(parent);
        File[] tmp = root.listFiles();
        List<File> result = new ArrayList<>();
        Queue<File> dataList = new LinkedList<>();
        if (root.isDirectory() && tmp != null) {
            dataList.addAll(Arrays.asList(tmp));
        }
        while (!dataList.isEmpty()) {
            File data = dataList.poll();
            if (data.isFile()) {
                if (pr.test(data.getName())) {
                    result.add(data);
                }
            } else if (data.isDirectory()) {
                tmp = data.listFiles();
                if (tmp != null) {
                    dataList.addAll(Arrays.asList(tmp));
                }
            }
        }
        return result;
    }
}