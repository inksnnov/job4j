package ru.job4j.address;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для работы с клиентами.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class Profiles {

    /**
     * Метод собирает все адреса со всех профией и отдает списком
     * используя Stream API.
     *
     * @param profile Profile.
     * @return List<Address>.
     */
    public List<Address> collect(List<Profile> profile) {
        return profile.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    /**
     * Метод собирает все адреса со всех профией, удаляет дубликаты,
     * сортирует по городу и отдает списком используя Stream API.
     *
     * @param profile Profile.
     * @return List<Address>.
     */
    public List<Address> collectUniqueSort(List<Profile> profile) {
        return profile.stream()
                .distinct()
                .sorted((x, y) -> (
                        x.getAddress().getCity()
                                .compareToIgnoreCase(y.getAddress().getCity())
                ))
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
