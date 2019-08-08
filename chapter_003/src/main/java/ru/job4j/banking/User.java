package ru.job4j.banking;

/**
 * Класс реализует пользователя.
 */
public class User {

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Паспортные данные пользователя "ID".
     */
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
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
        return passport.equals(user.passport)
                && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return passport.hashCode();
    }
}
