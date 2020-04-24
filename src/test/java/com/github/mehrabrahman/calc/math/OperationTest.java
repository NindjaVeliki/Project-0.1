package com.github.mehrabrahman.calc.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OperationTest {
	OperationFactory factory;
	
	@Before
	public void setup() {
        factory = OperationFactory.getInstance();
	}
    
    @Test(expected = IllegalArgumentException.class)
    public void whenOperatorUnrecognizedThrowException() {
        factory.getOperation("unknown", "unknown");
    }

    @Test
    public void whenAddingSmallNumbers() {
        assertEquals(4.0, factory.getOperation("add", "2 2").calculate(), 0);
        assertEquals(25.0, factory.getOperation("add", "15 10").calculate(), 0);
        assertEquals(7.5, factory.getOperation("add", "5 2.5").calculate(), 0);
    }

    @Test
    public void whenSubtractingSmallNumbers() {
        assertEquals(0.0, factory.getOperation("sub", "2 2").calculate(), 0);
        assertEquals(5.0, factory.getOperation("sub", "15 10").calculate(), 0);
        assertEquals(2.5, factory.getOperation("sub", "5 2.5").calculate(), 0);
    }

    @Test
    public void whenMultiplyingSmallNumbers() {
        assertEquals(4.0, factory.getOperation("mul", "2 2").calculate(), 0);
        assertEquals(150.0, factory.getOperation("mul", "15 10").calculate(), 0);
        assertEquals(12.5, factory.getOperation("mul", "5 2.5").calculate(), 0);
    }

    @Test
    public void whenDividingSmallNumbers() {
        assertEquals(1.0, factory.getOperation("div", "2 2").calculate(), 0);
        assertEquals(1.5, factory.getOperation("div", "15 10").calculate(), 0);
        assertEquals(2.0, factory.getOperation("div", "5 2.5").calculate(), 0);
    }
}