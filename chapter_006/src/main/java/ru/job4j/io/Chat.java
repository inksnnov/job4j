package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * Консольный чат.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Chat {
    /**
     * Объект Random для выбора случаных слов.
     */
    private final Random random = new Random();
    /**
     * Файл базы слов.
     */
    private final File data;
    /**
     * Файл лога.
     */
    private final File log;
    /**
     * Объект RandomAccess для доступа к файлу с базой слов.
     */
    private RandomAccessFile dbInput;


    /**
     * Дефолтный конструктор.
     *
     * @param data файл базы слов.
     * @param log  файл лога.
     */
    public Chat(File data, File log) {
        this.data = data;
        this.log = log;
    }

    /**
     * Основной метод, запусающий чат, он же пишет лог
     * в файл log.
     */
    public void start() {
        try (PrintWriter writeLog = new PrintWriter(log);
             RandomAccessFile db = new RandomAccessFile(data, "r")) {
            dbInput = db;
            chat((str, rule) -> {
                if (rule) {
                    System.out.println(str);
                }
                writeLog.println(str);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Реализация чата, читает с консоли и пишет
     * в нее на основании BiConsumer'a.
     *
     * @param biConsumer Вывод в консоль.
     * @throws IOException может кидат исключение
     *                     связанное с выдачей рандомных слов.
     */
    private void chat(BiConsumer<String, Boolean> biConsumer) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean mute = false;
        boolean exit = false;
        String answer;
        do {
            System.out.print(("Введите сообщение:"));
            biConsumer.accept(answer = scanner.nextLine(), false);
            if (answer.toLowerCase().equals("стоп")) {
                mute = true;
            } else if (answer.toLowerCase().equals("продолжить")) {
                mute = false;
            } else if (answer.toLowerCase().equals("закончить")) {
                exit = true;
            }
            if (!mute && !exit) {
                biConsumer.accept(randomWord(), true);
            }
        } while (!exit);

    }

    /**
     * Метод достает рандомное слово из файла,
     * при условии одна строка - одно слово.
     * Берем рандомное long число
     * от 0 до dbInput.length().
     * Ставим позицию в файле на рандомное число.
     * Если позиция не нулевая делаем readLine для
     * корректного перехода на новую строку,
     * зачем считываем строку до символа возврата каретки
     * или перехода на новую строку, преобразуем в массив,
     * отдаем String в кодировке UTF-8.
     *
     * @return рандомное слово.
     * @throws IOException может кидать исключение
     *                     связанное с доступом к файлу.
     */
    private String randomWord() throws IOException {
        List<Integer> tmp = new ArrayList<>();
        while (tmp.isEmpty()) {
            long rand = Math.abs(random.nextLong()) % dbInput.length();
            dbInput.seek(rand);
            if (rand != 0) {
                dbInput.readLine();
            }
            int r;
            while ((r = dbInput.read()) != -1) {
                if ((char) r == '\r' || (char) r == '\n') {
                    break;
                }
                tmp.add(r);
            }
        }
        byte[] result = new byte[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            result[i] = tmp.get(i).byteValue();
        }
        return new String(result, StandardCharsets.UTF_8);
    }
}
