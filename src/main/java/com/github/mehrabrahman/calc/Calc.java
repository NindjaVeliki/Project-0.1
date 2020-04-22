package com.github.mehrabrahman.calc;

import java.util.List;

import com.github.mehrabrahman.calc.io.FileParser;
import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

class Calc {
	public static void main(String[] args) {
		// Parse input: 1) parse subcommand, 2) parse operands
		if (args.length == 3) {
			OperationFactory factory = OperationFactory.getInstance();
			Operation operation = factory.getOperation(args);
			
			// Input
			FileParser fp = new FileParser();
			fp.insert(operation);
	
			// Output			
			List<Operation> operations = fp.readAll();
			
			for(Operation o : operations) {
				System.out.println(o);
			}
			
		} else {
			System.out.println("Usage: calc [operation] [operand] [operand]");
		}
	}
}