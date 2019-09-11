package ru.job4j.address;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class ProfilesTest {

    private static List<Profile> profileList;

    private Profiles profiles = new Profiles();

    @BeforeClass
    public static void loadProfiles() {
        ProfilesTest.profileList = Arrays.asList(
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("Minsk", "Lenina", 2, 44)),
                new Profile(new Address("Balakhna", "Olimpiyskaya", 5, 21)),
                new Profile(new Address("Kstovo", "Panina", 42, 56)),
                new Profile(new Address("Kstovo", "Panina", 42, 56)),
                new Profile(new Address("Yakutsk", "Lenina", 34, 12)),
                new Profile(new Address("Podolsk", "Kuzbass", 12, 21)),
                new Profile(new Address("Kirov", "Zhukovskaya", 44, 2)),
                new Profile(new Address("Kirov", "Zhukovskaya", 44, 2)),
                new Profile(new Address("Korolev", "Gagarina", 1, 2)),
                new Profile(new Address("Moscow", "Taganskaya", 53, 116)),
                new Profile(new Address("Murmansk", "Griboedova", 2, 2))
        );
    }

    @Test
    public void collectAddressTestOne() {
        List<Address> result = profiles.collect(profileList);
        assertThat(result.size(), is(10));
    }

    @Test
    public void collectUniqueSortTestOne() {
        List<Address> result = profiles.collectUniqueSort(profileList);
        List<Address> expect = Arrays.asList(
                new Address("Balakhna", "Olimpiyskaya", 5, 21),
                new Address("Kirov", "Zhukovskaya", 44, 2),
                new Address("Korolev", "Gagarina", 1, 2),
                new Address("Kstovo", "Panina", 42, 56),
                new Address("Minsk", "Lenina", 2, 44),
                new Address("Moscow", "Red Square", 1, 1),
                new Address("Moscow", "Taganskaya", 53, 116),
                new Address("Murmansk", "Griboedova", 2, 2),
                new Address("Podolsk", "Kuzbass", 12, 21),
                new Address("Yakutsk", "Lenina", 34, 12));
        assertThat(result, is(expect));
    }
}
