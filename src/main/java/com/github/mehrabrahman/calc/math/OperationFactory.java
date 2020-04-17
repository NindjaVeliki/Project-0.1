package com.github.mehrabrahman.calc.math;

public class OperationFactory {
	public static Outputtable getOperation(String[] args) {
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
			return null;
		}
	}
}
