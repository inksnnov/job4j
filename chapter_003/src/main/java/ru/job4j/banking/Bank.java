package ru.job4j.banking;

import java.util.*;

/**
 * Реализация методов для управления пользователями банка,
 * счетами и переводом денег между счетами.
 *
 * @author Khomichevskiy Alexandr.
 * @version 1.0
 */
public class Bank {

    /**
     * Хранилище пользвателей как ключа и его счетов как значение.
     */
    private Map<User, ArrayList<Account>> userDB = new HashMap<>();

    /**
     * Метод добавляет пользователя типа User в userDB,
     * если такой пользователь уже есть, не добавляем и возвращаем false.
     *
     * @param user новый пользователь.
     * @return true если добавили, false если нет.
     */
    public boolean addUser(User user) {
        boolean result = false;
        if (user != null) {
            result = this.userDB.putIfAbsent(user, new ArrayList<>()) == null;
        }
        return result;
    }

    /**
     * Удаление пользователя из базы userDB.
     *
     * @param user существующий удаляемый пользователь.
     * @return true если пользователь удален, false если не удален или не найден.
     */
    public boolean deleteUser(User user) {
        boolean result = false;
        if (user != null) {
            result = this.userDB.remove(user) != null;
        }
        return result;
    }

    /**
     * Добавление аккаунта-счета к существующему пользователю.
     *
     * @param passport паспорт объекта User которому добавляем аккаунт.
     * @param account  новый аккаунт-счет.
     * @return true если добавили, false если не добавлен или неверные входные данные
     * переменной passport.
     */
    public boolean addAccountToUser(String passport, Account account) {
        boolean result = false;
        User user = findUsrByPass(passport);
        if (user != null) {
            result = this.userDB.get(user).add(account);
        }
        return result;
    }

    /**
     * Удаление аккаунта-счета у существующего пользователя.
     *
     * @param passport паспорт объекта User у которого удаляем аккаунт.
     * @param account  существующий аккаунт-счет.
     * @return true если удалили, false если не удален или неверные входные данные
     * переменной passport или неверный account.
     */
    public boolean deleteAccountToUser(String passport, Account account) {
        boolean result = false;
        User user = findUsrByPass(passport);
        if (user != null) {
            result = this.userDB.get(user).remove(account);
        }
        return result;
    }

    /**
     * Выводит список всех счетов пользователя.
     *
     * @param passport String passport объекта User.
     * @return список объектов Account относящихся к данному пользователю.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.userDB.entrySet().stream()
                .filter(x -> x.getKey().getPassport().equals(passport))
                .map(Map.Entry::getValue)
                .findAny()
                .orElse(new ArrayList<>());
    }

    /**
     * Перевод денег с требуемого счета одного пользователя, на требуемый
     * счет другого(можно в рамках одного пользователя).
     *
     * @param srcPassport  passport Usera со счетов которого нужно произвести перевод.
     * @param srcRequisite реквизиты счета с которого делаем перевод первого Usera.
     * @param dstPassport  passport Usera куда делаем перевод.
     * @param dstRequisite реквизиты счета куда делаем перевод второго Usera.
     * @param amount       сумма перевода.
     * @return если перевод успешен true, если входные данные не верны или сумма перевода
     * превышает сумму остатка тогда false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        User srcUser = findUsrByPass(srcPassport);
        User dstUser = findUsrByPass(dstPassport);
        Account srcAcc = findAccount(srcUser, srcRequisite);
        Account dstAcc = findAccount(dstUser, dstRequisite);
        if (srcUser != null && dstUser != null && srcAcc != null
                && dstAcc != null && srcAcc.getValue() - amount >= 0) {
            dstAcc.setValue(dstAcc.getValue() + amount);
            srcAcc.setValue(srcAcc.getValue() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Вспомогательный метод поиска пользователя по паспорту.
     *
     * @param passport String passport Usera.
     * @return найденный User, иначе new User("0", "0").
     */
    private User findUsrByPass(String passport) {
        return this.userDB.keySet()
                .stream()
                .filter(x -> x.getPassport().equals(passport))
                .findAny()
                .orElse(null);
    }

    /**
     * Вспомогательный метод поиска индекса аккаунта у пользователя по реквизитам.
     *
     * @param user      пользователь User.
     * @param requisite реквизиты искомого счета.
     * @return индекс найденного счета в List<Account>, иначе вернет -1.
     */
    private Account findAccount(User user, String requisite) {
        return this.userDB.get(user)
                .stream()
                .filter(x -> x.getRequisites().equals(requisite))
                .findAny()
                .orElse(null);
    }
}
