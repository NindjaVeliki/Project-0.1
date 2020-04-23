package com.github.mehrabrahman.calc;

import java.util.List;

import com.github.mehrabrahman.calc.io.FileParser;
import com.github.mehrabrahman.calc.io.OperationRepository;
import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

class Calc {
	public static void main(String[] args) {
		final String input = System.getProperty("input", "input.csv");
		final String output = System.getProperty("output", "output.csv");

		if (args != null) {
			if (args[0].equalsIgnoreCase("parse")) {
				FileParser fParser = new FileParser(input, output);
				List<Operation> operations = fParser.readAll();
				for(Operation o : operations) {
					o.calculate();
				}

				OperationRepository oRepository = new OperationRepository();
				oRepository.insertAll(operations);
				
				for(Operation o : operations) {
					System.out.println(o);
				}				
			} else {
				String operator = args[0];
				String sOperands = args[1];
				OperationFactory factory = OperationFactory.getInstance();
				Operation operation = factory.getOperation(operator, sOperands);
				operation.calculate();
				System.out.println(operation.getResult());
			} 
		} else {
			System.out.println("Usage: calc [operation] [operand] [operand]");
		}
	}
}