package ru.job4j.user;

import org.junit.Before;
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

    private UserConvert convert = new UserConvert();

    private List<User> input;

    @Before
    public void load() {
        this.input = new ArrayList<>(List.of(
                new User("Alexey", "Moscow"),
                new User("Ivan", "Novgorod"),
                new User("Oleg", "Omsk"),
                new User("Max", "Sarov"),
                new User("Igor", "Sochi")));
    }

    @Test
    public void processTestLength5() {
        Map<Long, User> expect = Map.of(
                this.input.get(0).getId(), this.input.get(0),
                this.input.get(1).getId(), this.input.get(1),
                this.input.get(2).getId(), this.input.get(2),
                this.input.get(3).getId(), this.input.get(3),
                this.input.get(4).getId(), this.input.get(4));
        assertThat(this.convert.process(this.input), is(expect));
    }

    @Test
    public void processTestLength4() {
        List<User> inputFour = Arrays.asList(
                this.input.get(0),
                this.input.get(1),
                this.input.get(2),
                this.input.get(3));
        Map<Long, User> expect = Map.of(
                this.input.get(0).getId(), this.input.get(0),
                this.input.get(1).getId(), this.input.get(1),
                this.input.get(2).getId(), this.input.get(2),
                this.input.get(3).getId(), this.input.get(3));
        assertThat(this.convert.process(inputFour), is(expect));
    }

    @Test
    public void processTestLengthNone() {
        List<User> inputNone = new ArrayList<>();
        HashMap<Long, User> expect = new HashMap<>();
        assertThat(this.convert.process(inputNone), is(expect));
    }


}
