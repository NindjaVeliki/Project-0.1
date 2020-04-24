package com.github.mehrabrahman.calc.math;

/**
 * @author Mehrab
 *
 */
public class Sub extends Operation {
	public Sub(String operator, String sOperands) {
		super(operator, sOperands);
	}

	@Override
	public double calculate() {
		this.result = this.operands[0];
		for (int i = 1; i < this.operands.length; i++) {
			this.result -= this.operands[i];
		}

		return this.result;
	}
}
