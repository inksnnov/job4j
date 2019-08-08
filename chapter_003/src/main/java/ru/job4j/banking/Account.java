package ru.job4j.banking;

import java.util.Objects;

/**
 * Класс реализует аккаунт-счет пользователя.
 */
public class Account {

    /**
     * Остаток на счете.
     */
    private double value;

    /**
     * Реквизиты счета.
     */
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return requisites.equals(account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
