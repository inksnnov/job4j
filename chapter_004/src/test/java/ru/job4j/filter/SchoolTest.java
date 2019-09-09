package ru.job4j.filter;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class SchoolTest {

    private static List<Student> students;

    private School school = new School();

    @BeforeClass
    public static void loadStudents() {
        SchoolTest.students = Arrays.asList(
                new Student(100), new Student(40),
                new Student(20), new Student(60),
                new Student(90), new Student(70),
                new Student(35), new Student(80),
                new Student(22), new Student(75),
                new Student(90), new Student(90),
                new Student(10), new Student(0),
                new Student(55), new Student(80),
                new Student(10), new Student(100));
    }

    @Test
    public void schoolSortHigh() {
        List<Student> high = this.school.collect(SchoolTest.students,
                w -> w.score >= 70);
        assertThat(high.size(), is(9));

    }

    @Test
    public void schoolSortMedium() {
        List<Student> medium = this.school.collect(SchoolTest.students,
                w -> w.score >= 50 && w.score < 70);
        assertThat(medium.size(), is(2));
    }

    @Test
    public void schoolSortLow() {
        List<Student> low = this.school.collect(SchoolTest.students,
                w -> w.score < 50);
        assertThat(low.size(), is(7));
    }


}
