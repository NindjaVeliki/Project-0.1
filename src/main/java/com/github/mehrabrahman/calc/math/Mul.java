/**
 * 
 */
package com.github.mehrabrahman.calc.math;

/**
 * @author Mehrab
 *
 */
public class Mul extends Operation {
	
	public Mul(String ...args) {
		super(args);
	}

	@Override
	public double output() {
		return this.a * this.b;
	}
}
