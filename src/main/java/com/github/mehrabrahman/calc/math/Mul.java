package com.github.mehrabrahman.calc.math;

/**
 * @author Mehrab
 *
 */
public class Mul extends Operation {
	public Mul(String operator, String sOperands) {
		super(operator, sOperands);
	}

	@Override
	public void calculate() {
		result = operands[0];
		for (int i = 1; i < operands.length; i++) {
			result *= operands[i];
		}
	}
}
