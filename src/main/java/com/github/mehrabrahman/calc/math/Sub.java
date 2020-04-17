/**
 * 
 */
package com.github.mehrabrahman.calc.math;

/**
 * @author Mehrab
 *
 */
public final class Sub extends Operation {

	public Sub(String[] args) {
		super(args);
	}
	
	@Override
	public double output() {
		return this.a - this.b;
	}
	
	@Override
	public String toString() {
		return this.a + " - " + this.b + " = " + getOutput();
	}

}
