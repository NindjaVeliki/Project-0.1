package com.github.mehrabrahman.calc.math;

/**
This class holds data for an operation.
@author Mehrab
@version 0.1.0
*/
public abstract class Operation implements Outputtable {
	protected String operation;
    protected double a;
    protected double b;
    protected double output;
    
    public Operation() {}

    public Operation(String[] args) {
        if (args.length > 0) {
            try {
            	this.operation = args[0];
                this.a = Double.parseDouble(args[1]);
                this.b = Double.parseDouble(args[2]);
                this.output = this.output();
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
                System.exit(1);
            }
        }
    }
    
    @Override
    public String toString() {
    	return this.operation + "," + this.a + "," + this.b + "," + this.output;
    }
}