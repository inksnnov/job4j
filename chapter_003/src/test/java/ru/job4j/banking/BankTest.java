package ru.job4j.banking;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {

    private Bank bank;

    private User user;

    private User userTwo;

    private Account account;

    private Account accountTwo;

    @Before
    public void load() {
        this.bank = new Bank();
        this.user = new User("Ivan", "0000");
        this.userTwo = new User("Igor", "1111");
        this.account = new Account(100, "1234");
        this.accountTwo = new Account(200, "4321");
    }

    @Test
    public void addUserTestOne() {
        assertTrue(this.bank.addUser(this.user));
    }

    @Test
    public void addUserTestTwo() {
        this.bank.addUser(this.user);
        assertFalse(this.bank.addUser(this.user));
    }

    @Test
    public void addUserTestThree() {
        assertFalse(this.bank.addUser(null));
    }

    @Test
    public void deleteUserTestOne() {
        this.bank.addUser(this.user);
        assertTrue(this.bank.deleteUser(this.user));
    }

    @Test
    public void deleteUserTestTwo() {
        this.bank.addUser(this.user);
        assertFalse(this.bank.deleteUser(this.userTwo));
    }

    @Test
    public void deleteUserTestThree() {
        assertFalse(this.bank.deleteUser(null));
    }

    @Test
    public void addAccountToUserTestOne() {
        this.bank.addUser(this.user);
        this.bank.addAccountToUser("0000", this.account);
        assertThat(this.bank.getUserAccounts("0000").get(0), is(this.account));
    }

    @Test
    public void addAccountToUserTestTwo() {
        assertFalse(this.bank.addAccountToUser(null, null));
    }

    @Test
    public void deleteAccountToUserTestOne() {
        this.bank.addUser(this.user);
        this.bank.addAccountToUser("0000", this.account);
        this.bank.deleteAccountToUser("0000", this.account);
        assertTrue(this.bank.getUserAccounts("0000").isEmpty());
    }

    @Test
    public void deleteAccountToUserTestTwo() {
        this.bank.addUser(this.user);
        this.bank.addAccountToUser("0000", this.account);
        this.bank.deleteAccountToUser("0000", this.account);
        assertFalse(this.bank.deleteAccountToUser("0000", this.account));
    }

    @Test
    public void deleteAccountToUserTestThree() {
        this.bank.addUser(this.user);
        assertFalse(this.bank.deleteAccountToUser("0000", null));
    }

    @Test
    public void getUserAccountsTest() {
        this.bank.addUser(this.user);
        this.bank.addAccountToUser("0000", this.account);
        assertThat(this.bank.getUserAccounts("0000").get(0), is(this.account));
    }

    @Test
    public void transferMoneyTestOne() {
        this.bank.addUser(this.user);
        this.bank.addUser(this.userTwo);
        this.bank.addAccountToUser("0000", this.account);
        this.bank.addAccountToUser("1111", this.accountTwo);
        assertTrue(this.bank.transferMoney("0000", "1234",
                "1111", "4321", 100));
    }

    @Test
    public void transferMoneyTestTwo() {
        this.bank.addUser(this.user);
        this.bank.addUser(this.userTwo);
        this.bank.addAccountToUser("0000", this.account);
        this.bank.addAccountToUser("1111", this.accountTwo);
        assertFalse(this.bank.transferMoney("0000", "1234",
                "1111", "4321", 200));
    }
}
