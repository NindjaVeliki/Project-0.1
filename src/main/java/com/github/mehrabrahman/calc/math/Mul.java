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
	public double calculate() {
		this.result = this.operands[0];
		for (int i = 1; i < this.operands.length; i++) {
			this.result *= this.operands[i];
		}

		return result;
	}
}
