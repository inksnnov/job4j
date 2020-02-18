package ru.job4j.io;

import java.io.File;
import java.util.*;

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
     * @param exist  расширения искомых файлов.
     * @return Список найденных файлов.
     */
    public List<File> files(String parent, List<String> exist) {
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
                for (String end : exist) {
                    if (data.getName().endsWith(end)) {
                        result.add(data);
                        break;
                    }
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