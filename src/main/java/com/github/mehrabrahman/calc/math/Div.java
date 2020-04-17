/**
 * 
 */
package com.github.mehrabrahman.calc.math;

/**
 * @author Mehrab
 *
 */
public class Div extends Operation {
	
	public Div(String[] args) {
		super(args);
	}

	@Override
	public double output() {
		return this.a / this.b;
	}
	
	@Override
	public String toString() {
		return this.a + " / " + this.b + " = " + getOutput();
	}

}
