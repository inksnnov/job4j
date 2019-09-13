package ru.job4j.teststream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Тесты к классу StudentScopeCompare
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class StudentScopeCompareTest {

    private static List<Student> students;

    private static List<Student> studentsNull;

    private StudentScopeCompare scopeCompare = new StudentScopeCompare();

    @BeforeClass
    public static void load() {
        StudentScopeCompareTest.students = Arrays.asList(
                new Student("A", 10),
                null,
                new Student("B", 70),
                new Student("C", 50),
                new Student("D", 25),
                null,
                new Student("F", 90),
                new Student("Q", 80),
                new Student("X", 100),
                new Student("W", 60));
        StudentScopeCompareTest.studentsNull = Arrays.asList(
                null, null, null, null, null
        );
    }

    @Test
    public void levelOfTestOne() {
        List<Student> result = scopeCompare.levelOf(
                StudentScopeCompareTest.students, 60);
        assertThat(result.size(), is(5));
    }

    @Test
    public void levelOfTestTwo() {
        List<Student> result = scopeCompare.levelOf(
                StudentScopeCompareTest.studentsNull, 60);
        assertThat(result, is(empty()));
    }
}
