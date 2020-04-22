package com.github.mehrabrahman.calc.math;

/**
This class holds data for an operation.
@author Mehrab
@version 0.1.0
*/
public abstract class Operation implements Outputtable {
	protected int id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		temp = Double.doubleToLongBits(output);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operation other = (Operation) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (operation == null) {
			if (other.operation != null)
				return false;
		} else if (!operation.equals(other.operation))
			return false;
		if (Double.doubleToLongBits(output) != Double.doubleToLongBits(other.output))
			return false;
		return true;
	}
    
    
}