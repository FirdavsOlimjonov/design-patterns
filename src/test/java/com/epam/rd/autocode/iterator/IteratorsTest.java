package com.epam.rd.autocode.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IteratorsTest {

    @Test
    public void intArrayTwoTimesIterator() {
        testCase2IntIterator(new int[]{1, 2, 3}, "[1, 1, 2, 2, 3, 3]");
        testCase2IntIterator(new int[]{5, 0, -5, 0}, "[5, 5, 0, 0, -5, -5, 0, 0]");
        testCase2IntIterator(new int[]{}, "[]");
        testCase2IntIterator(new int[]{1, 1, 1, 1, 0, 1}, "[1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1]");

        assertThrows(
                NoSuchElementException.class,
                () -> Iterators.intArrayTwoTimesIterator(new int[]{}).next());

        final Iterator<Integer> itr = Iterators.intArrayTwoTimesIterator(new int[]{1});
        itr.next();
        itr.next();
        assertThrows(NoSuchElementException.class, () -> itr.next());
    }

    @Test
    public void intArrayThreeTimesIterator() {
        testCase3IntIterator(new int[]{1, 2, 3}, "[1, 1, 1, 2, 2, 2, 3, 3, 3]");
        testCase3IntIterator(new int[]{5, 0, -5, 0}, "[5, 5, 5, 0, 0, 0, -5, -5, -5, 0, 0, 0]");
        testCase3IntIterator(new int[]{}, "[]");
        testCase3IntIterator(new int[]{1, 1, 1, 1, 0, 1}, "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1]");

        assertThrows(
                NoSuchElementException.class,
                () -> Iterators.intArrayThreeTimesIterator(new int[]{}).next());

        final Iterator<Integer> itr = Iterators.intArrayThreeTimesIterator(new int[]{1});
        itr.next();
        itr.next();
        itr.next();
        assertThrows(NoSuchElementException.class, () -> itr.next());
    }

    @Test
    public void intArrayFiveTimesIterator() {
        testCase5IntIterator(new int[]{1, 2, 3}, "[1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3]");
        testCase5IntIterator(new int[]{5, 0, -5, 0}, "[5, 5, 5, 5, 5, 0, 0, 0, 0, 0, -5, -5, -5, -5, -5, 0, 0, 0, 0, 0]");
        testCase5IntIterator(new int[]{}, "[]");
        testCase5IntIterator(new int[]{1, 1, 1, 1, 0, 1}, "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1]");

        assertThrows(
                NoSuchElementException.class,
                () -> Iterators.intArrayFiveTimesIterator(new int[]{}).next());

        final Iterator<Integer> itr = Iterators.intArrayFiveTimesIterator(new int[]{1});
        itr.next();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
        assertThrows(NoSuchElementException.class, () -> itr.next());
    }


    private void testCase2IntIterator(final int[] array, final String expected) {
        testCaseIntIterator(expected, Iterators.intArrayTwoTimesIterator(array));
    }

    private void testCase3IntIterator(final int[] array, final String expected) {
        testCaseIntIterator(expected, Iterators.intArrayThreeTimesIterator(array));
    }

    private void testCase5IntIterator(final int[] array, final String expected) {
        testCaseIntIterator(expected, Iterators.intArrayFiveTimesIterator(array));
    }

    private void testCaseIntIterator(final String expected, final Iterator<Integer> integerIterator) {
        List<Integer> sink = new ArrayList<>();
        while (integerIterator.hasNext()) {
            sink.add(integerIterator.next());
        }
        assertEquals(expected, sink.toString());
    }

    @Test
    public void wordIterator() {
    }

    @Test
    public void table() {
    }
}