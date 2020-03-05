package ru.job4j.total;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Реализация определения разницы двух листов.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Analyze {

    /**
     * Метод определяет разницу между двумя списками типа User.
     *
     * @param previous начальный список.
     * @param current  измененный список.
     * @return Info итоговые изменения.
     */
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, User> map = new HashMap<>();
        for (User user : current) {
            map.put(user.id, user);
        }
        for (User oldUser : previous) {
            User value = map.putIfAbsent(oldUser.id, oldUser);
            if (value == null) {
                info.deleted++;
            } else if (!value.name.equals(oldUser.name)) {
                info.changed++;
            }
        }
        info.added = current.size() - (previous.size() - info.deleted);
        return info;
    }

    /**
     * Модель юзера.
     */
    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    /**
     * Модель статистики изменений в листах.
     */
    public static class Info {
        /**
         * Сколько пользователей добавлено.
         */
        int added;
        /**
         * Сколько пользователей изменено(без смены id).
         */
        int changed;
        /**
         * Сколько пользователей удалено.
         */
        int deleted;
    }

}