package com.github.mehrabrahman.calc.math;

/**
 * @author Mehrab
 *
 */
public class Add extends Operation {
	public Add(String operator, String sOperands) {
		super(operator, sOperands);
	}

	@Override
	public void calculate() {
		for (int i = 0; i < operands.length; i++) {
			result += operands[i];
		}
	}
}
