package ru.job4j.generics;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}
