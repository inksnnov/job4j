package ru.job4j.user;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        return list.stream()
                .collect(Collectors.toMap(User::getId, Function.identity(),
                        (oldValue, newValue) -> newValue, HashMap::new));
    }
}
