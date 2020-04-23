package com.github.mehrabrahman.calc;

import java.util.List;

import com.github.mehrabrahman.calc.io.FileParser;
import com.github.mehrabrahman.calc.io.OperationRepository;
import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

class Calc {
	public static void main(String[] args) {
		if (args != null) {
			// Parse input from file and insert into sql database
			if (args[0].equals("parse")) {
				FileParser fParser = new FileParser(args[1]);
				List<Operation> operations = fParser.readAll();

				// Calculate on all operations loaded from input file
				for(Operation o : operations) {
					o.calculate();
				}

				// Insert operations into database
				OperationRepository oRepository = new OperationRepository();
				oRepository.insertAll(operations);

				// Read all operations from database
				operations = oRepository.readAll();				
				for(Operation o : operations) {
					System.out.println(o);
				}
			} else {
				// Single operation mode - no file or database required
				String operator = args[0];
				String sOperands = args[1];
				OperationFactory factory = OperationFactory.getInstance();
				Operation operation = factory.getOperation(operator, sOperands);
				operation.calculate();
				System.out.println(operation.getResult());
			} 
		} else {
			// Help output
			System.out.println("Usage:");
			System.out.println("	calc parse [file.csv]");
			System.out.println("	calc [operation] [operand] [operand]");
		}
	}
}