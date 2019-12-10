package ru.job4j.generics;

import java.util.Objects;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id.equals(base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}