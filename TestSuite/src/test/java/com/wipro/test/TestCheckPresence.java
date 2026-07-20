package com.wipro.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.wipro.task.DailyTasks;

public class TestCheckPresence {

    @Test
    public void testCheckPresenceTrue() {

        DailyTasks dt = new DailyTasks();

        assertTrue(dt.checkPresence("Wipro Technologies", "Tech"));
    }

    @Test
    public void testCheckPresenceFalse() {

        DailyTasks dt = new DailyTasks();

        assertFalse(dt.checkPresence("Wipro Technologies", "Infosys"));
    }
}