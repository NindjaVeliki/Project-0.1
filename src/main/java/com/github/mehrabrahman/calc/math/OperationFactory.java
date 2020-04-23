package com.github.mehrabrahman.calc.math;

public class OperationFactory {
	private static OperationFactory instance;

	private OperationFactory() {}

	public static OperationFactory getInstance() {
		if (instance == null) {
			instance = new OperationFactory();
		}
		return instance;
	}

	public Operation getOperation(String operator, String sOperands) {
		switch (operator) {
		case "add":
			return new Add(operator, sOperands);
		case "sub":
			return new Sub(operator, sOperands);
		case "mul":
			return new Mul(operator, sOperands);
		case "div":
			return new Div(operator, sOperands);
		default:
			throw new IllegalArgumentException("Operation not recognized");
		}
	}
}
