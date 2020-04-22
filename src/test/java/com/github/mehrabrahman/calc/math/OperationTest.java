package com.github.mehrabrahman.calc.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OperationTest {
	Outputtable testOp;
	OperationFactory factory;
	
	@Before
	public void setup() {
        String[] args = {"add", "2", "2"};
        this.testOp = new Mul(args);
        factory = OperationFactory.getInstance();
	}

    @Test
    public void whenAdding2And2ThenOutput4() {
        // Experiment
        double expected = 4.0;
        double actual = testOp.output();

        // Assert
        assertEquals(expected, actual, 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void whenMissingSubcommandArgsThrowException() {
    	String[] args = {"ad", "2", "2"};
    	this.testOp = factory.getOperation(args);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void whenNonStringSubcommandArgsThrowException() {
    	String[] args = {"2", "2"};
    	this.testOp = factory.getOperation(args);
    }
}