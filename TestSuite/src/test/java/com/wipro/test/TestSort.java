package com.wipro.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.wipro.task.DailyTasks;

public class TestSort {

    @Test
    public void testSortValues() {

        DailyTasks dt = new DailyTasks();

        int[] input = {5, 2, 8, 1, 4};
        int[] expected = {1, 2, 4, 5, 8};

        int[] actual = dt.sortValues(input);

        assertArrayEquals(expected, actual);
    }
}