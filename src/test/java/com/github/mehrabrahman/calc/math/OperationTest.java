package com.github.mehrabrahman.calc.math;

import org.junit.Before;
import org.junit.Test;

public class OperationTest {
	OperationFactory factory;
	
	@Before
	public void setup() {
        factory = OperationFactory.getInstance();
	}

    @Test
    public void whenAdding2And2ThenOutput4() {
    }
    
    //@Test(expected = IllegalArgumentException.class)
    public void whenMissingSubcommandArgsThrowException() {
    }
}