package com.github.mehrabrahman.calc.math;

public class OperationFactory {
	private static OperationFactory instance;

	private OperationFactory() {
	}

	public static OperationFactory getInstance() {
		if (instance == null) {
			instance = new OperationFactory();
		}
		return instance;
	}

	public Outputtable getOperation(String[] args) {
		String subcommand = args[0];
		switch (subcommand) {
		case "add":
			return new Add(args);
		case "sub":
			return new Sub(args);
		case "mul":
			return new Mul(args);
		case "div":
			return new Div(args);
		default:
			throw new IllegalArgumentException("Operation not recognized");
		}
	}
}
