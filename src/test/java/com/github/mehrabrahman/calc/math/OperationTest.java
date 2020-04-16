package com.github.mehrabrahman.calc.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperationTest {

    @Test
    public void whenAdding2And2ThenOutput4() {
        // Setup
        String[] args = {"add", "2", "2"};
        Operation testOp = new Operation(args);

        // Experiment
        double expected = 4.0;
        double actual = testOp.getOutput();

        // Assert
        assertEquals(expected, actual, 0.0);
    }
}