package ru.job4j.user;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты к классу UserConvert(конвертация List<User> в Map<Long, User>.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class UserConvertTest {

    @Test
    public void processTestLength5() {
        UserConvert convert = new UserConvert();
        User user1 = new User("Alexey", "Moscow");
        User user2 = new User("Ivan", "Novgorod");
        User user3 = new User("Oleg", "Omsk");
        User user4 = new User("Max", "Sarov");
        User user5 = new User("Igor", "Sochi");
        List<User> input = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5));
        HashMap<Long, User> expect = new HashMap<>();
        expect.put(user1.getId(), user1);
        expect.put(user2.getId(), user2);
        expect.put(user3.getId(), user3);
        expect.put(user4.getId(), user4);
        expect.put(user5.getId(), user5);
        assertThat(convert.process(input), is(expect));
    }

    @Test
    public void processTestLength4() {
        UserConvert convert = new UserConvert();
        User user1 = new User("Alexey", "Moscow");
        User user2 = new User("Ivan", "Novgorod");
        User user3 = new User("Oleg", "Omsk");
        User user4 = new User("Max", "Sarov");
        List<User> input = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
        HashMap<Long, User> expect = new HashMap<>();
        expect.put(user1.getId(), user1);
        expect.put(user2.getId(), user2);
        expect.put(user3.getId(), user3);
        expect.put(user4.getId(), user4);
        assertThat(convert.process(input), is(expect));
    }

    @Test
    public void processTestLengthNone() {
        UserConvert convert = new UserConvert();
        List<User> input = new ArrayList<>();
        HashMap<Long, User> expect = new HashMap<>();
        assertThat(convert.process(input), is(expect));
    }


}
