package com.github.mehrabrahman.calc;

import java.util.ArrayList;

import com.github.mehrabrahman.calc.io.FileParser;
import com.github.mehrabrahman.calc.math.OperationFactory;
import com.github.mehrabrahman.calc.math.Outputtable;

class Calc {
	public static void main(String[] args) {
		// Parse input: 1) parse subcommand, 2) parse operands
		OperationFactory factory = OperationFactory.getInstance();
		Outputtable operation = factory.getOperation(args);

		// Output
		System.out.println(operation);

		FileParser.write(operation);
		
		ArrayList<Outputtable> operations = new ArrayList<>();
		FileParser.read(operations);
	}
}