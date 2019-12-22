package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Тесты к классу LinkedLocking.
 *
 * @author Alexandr Khomichevskiy.
 * @version 1.0.
 */
public class LinkedLockingTest {
    private LinkedLocking<Integer> check = new LinkedLocking<>();

    @Test
    public void circuitTestOne() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(check.hasCycle(first), is(true));
    }

    @Test
    public void circuitTestTwo() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = first;
        third.next = four;
        four.next = first;
        assertThat(check.hasCycle(first), is(true));
    }

    @Test
    public void circuitTestThree() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(check.hasCycle(first), is(false));
    }

    @Test
    public void circuitTestFour() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = null;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(check.hasCycle(first), is(false));
    }

    @Test
    public void circuitTestFive() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);
        Node<Integer> ten = new Node<>(10);
        Node<Integer> eleven = new Node<>(11);
        Node<Integer> twelve = new Node<>(12);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;
        ten.next = eleven;
        eleven.next = twelve;
        assertThat(check.hasCycle(first), is(false));
    }

    @Test
    public void circuitTestSix() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);
        Node<Integer> ten = new Node<>(10);
        Node<Integer> eleven = new Node<>(11);
        Node<Integer> twelve = new Node<>(12);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;
        ten.next = eleven;
        eleven.next = twelve;
        twelve.next = first;
        assertThat(check.hasCycle(first), is(true));
    }
}