package com.wipro.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wipro.task.DailyTasks;

public class TestStringConcat {

    @Test
    public void testDoStringConcat() {

        DailyTasks dt = new DailyTasks();

        String actual = dt.doStringConcat("Hello", "World");

        String expected = "Hello World";

        assertEquals(expected, actual);
    }
}