package ru.job4j.comparator;

import java.util.Comparator;
import java.util.List;

/**
 * Класс сравнения двух листов типа Character.
 */
public class ListCompare implements Comparator<String> {

    /**
     * Метод сравнивает два листа типа Character.
     * Сперва преобразовываем листы в строки с помощью StringBuilder,
     * заполняя через foreach, затем используем переопределенный метод
     * compare для сравнивания двух строк.
     *
     * @param l1  Список 1.
     * @param l2  Список 2.
     * @param <T> Character.
     * @return int если первый список больше второго возвращаем положительное число,
     * иначе отрицательное, если равны то 0.
     * @throws NullPointerException Если один или оба списка null кидаем исключение.
     */
    public <T extends Character> int compareLIst(List<T> l1, List<T> l2) {
        if (l1 == null || l2 == null) {
            throw new NullPointerException("List is null");
        }
        StringBuilder builder1 = new StringBuilder(l1.size());
        StringBuilder builder2 = new StringBuilder(l2.size());
        for (char ch : l1) {
            builder1.append(ch);
        }
        for (char ch : l2) {
            builder2.append(ch);
        }
        return this.compare(builder1.toString(), builder2.toString());
    }

    /**
     * Переопределенный метод compare сравнивает две строки созданный из
     * списков типа Character.
     * Сравниваем без учета регистра.
     * В цикле for сравниваем методом compare иза класса Character,
     * цикл for ограничен самым маленьким размеров строки.
     * Затем в переменную result суммируем значения.
     * Далее на основании сравнения, если после цикла result == 0 и длинна
     * строк разная, возвращаем длинную строку как большую.
     *
     * @param o1 String первая строка.
     * @param o2 String вторая строка.
     * @return int Если первая строка больше второй возвращаем положительное
     * число, иначе отрицательное, если равны то 0.
     */
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            result = Character.compare(o1.toLowerCase().charAt(i), o2.toLowerCase().charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && o1.length() != o2.length()) {
            result = o1.length() < o2.length() ? -1 : 1;
        }
        return result;
    }
}