package ru.job4j.generics;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class UserStore<T extends User> extends AbstractStore<T> {

    public UserStore(int size) {
        super(size);
    }

    @Override
    public void add(T model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public T findById(String id) {
        return super.findById(id);
    }
}
