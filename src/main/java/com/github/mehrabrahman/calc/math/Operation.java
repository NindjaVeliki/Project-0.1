package com.github.mehrabrahman.calc.math;

/**
This class holds data for an operation.
@author Mehrab
@version 0.1.0
*/
public abstract class Operation implements Calculatable {
	protected int id;
	protected String operator;
	protected String sOperands;
	protected double[] operands;
	protected double result;
	
	public Operation(String operator, String sOperands) {
		this.operator = operator;
		this.sOperands = sOperands;
		parse();
	}

	public Operation(int id, String operator, String sOperands, double result) {
		this.id = id;
		this.operator = operator;
		this.sOperands = sOperands;
		this.result = result;
		parse();
	}

	private void parse() {
		String[] tokens = sOperands.split(" ");
		this.operands = new double[tokens.length];
		for(int i = 0; i < tokens.length; i++) {
			try {
				operands[i] = Double.parseDouble(tokens[i]);
			} catch (NumberFormatException ex) {
				System.err.println("Unable to parse operand: " + tokens[i]);
			}
		}
	}

	public int getId() {
		return id;
	}

	public String getOperator() {
		return operator;
	}

	public String getSOperands() {
		return sOperands;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
    
    @Override
    public String toString() {
		StringBuilder out = new StringBuilder();
		out.append(this.id);
		out.append(",");
		out.append(this.operator);
		out.append(",");
		out.append(this.sOperands);
		out.append(",");
		out.append(this.result);
    	return out.toString();
    }
}