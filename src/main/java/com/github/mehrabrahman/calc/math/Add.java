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
	public double calculate() {
		for (int i = 0; i < this.operands.length; i++) {
			this.result += this.operands[i];
		}

		return this.result;
	}
}
