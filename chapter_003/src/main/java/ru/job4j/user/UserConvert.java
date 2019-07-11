package ru.job4j.user;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * Конвертация List<User> в Map<Long, User>.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */

public class UserConvert {

    /**
     * Метод конвертирует список юзеров в хешмап с ключом id пользователя и значением user.
     * Конвертируем в цикле while с применением итератора к листу.
     *
     * @param list входной список.
     * @return сконвертированный Map.
     */
    public HashMap<Long, User> process(List<User> list) {
        HashMap<Long, User> result = new HashMap<>();
        ListIterator<User> userIterator = list.listIterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            result.put(user.getId(), user);
        }
        return result;
    }
}
