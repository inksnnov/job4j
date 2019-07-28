package ru.job4j.sort;

/**
 * Класс пользователя.
 */
public class User implements Comparable<User> {

    /**
     * Поле - имя пользователя.
     */
    private String name;

    /**
     * Поле - возраст пользователя.
     */
    private int age;

    /**
     * Дефолтный конструктор принимает поле имя, возраст.
     *
     * @param name имя.
     * @param age  возраст.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Получаем имя.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Поучаем возраст.
     *
     * @return age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Переопределенный метод сравнивает пользователей по возрасту, если возраст одинаковый
     * сравнивает по имени.
     *
     * @param o User.
     * @return int.
     */
    @Override
    public int compareTo(User o) {
        int result = this.getAge() - o.getAge();
        return result == 0 ? this.getName().compareTo(o.getName()) : result;
    }

}
