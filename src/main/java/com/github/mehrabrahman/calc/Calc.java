package com.github.mehrabrahman.calc;

import java.io.File;
import java.util.List;

import com.github.mehrabrahman.calc.io.Dao;
import com.github.mehrabrahman.calc.io.FileOperationRepository;
import com.github.mehrabrahman.calc.io.SqlDataSource;
import com.github.mehrabrahman.calc.io.SqlOperationRepository;
import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;
import com.github.mehrabrahman.calc.server.HttpServer;
import com.github.mehrabrahman.calc.server.SocketServer;

/**
 * Calc is a basic calculator that reads one or more basic operations,
 * calculates their result, and saves them to a sql database.
 * 
 * @author Mehrab
 * @version 1.0.0
 */
class Calc {
	public static void main(String[] args) {
		if (args != null) {
			if (args[0].equals("server")) {
				SocketServer server = new SocketServer();
				server.listen();
			}
			
			else if (args[0].equals("http")) {
				HttpServer server = new HttpServer();
				System.out.println("Running http server on port 8080");
				server.listen();
			}
			
			// Parse input from file and insert into sql database
			else if (args[0].equals("parse")) {
				File input = new File(args[1]);
				Dao<Operation> fileParser = new FileOperationRepository(input);
				List<Operation> operations = fileParser.readAll();

				// Calculate on all operations loaded from input file
				for (Operation o : operations) {
					o.calculate();
				}

				// Insert operations into database
				SqlDataSource dataSource = SqlDataSource.getInstance();
				Dao<Operation> oRepository = new SqlOperationRepository(dataSource);
				oRepository.insertAll(operations);

				// Read all operations from database
				operations = oRepository.readAll();
				for (Operation o : operations) {
					System.out.println(o);
				}
			} else {
				// Single operation mode - no file or database required
				String operator = args[0];
				String sOperands = args[1];
				OperationFactory factory = OperationFactory.getInstance();
				Operation operation = factory.getOperation(operator, sOperands);
				System.out.println(operation.calculate());
			}
		} else {
			// Help output
			System.out.println("Usage:");
			System.out.println("	calc parse [file.csv]");
			System.out.println("	calc [operation] [operand] [operand]");
		}
	}
}