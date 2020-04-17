package com.github.mehrabrahman.calc.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OperationTest {
	Operation testOp;
	
	@Before
	public void setup() {
        String[] args = {"add", "2", "2"};
        this.testOp = new Mul(args);
	}

    @Test
    public void whenAdding2And2ThenOutput4() {
        // Experiment
        double expected = 4.0;
        double actual = testOp.getOutput();

        // Assert
        assertEquals(expected, actual, 0.0);
    }
}