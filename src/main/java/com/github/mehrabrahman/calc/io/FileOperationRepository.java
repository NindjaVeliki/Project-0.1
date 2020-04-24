package com.github.mehrabrahman.calc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

public class FileOperationRepository implements Dao<Operation> {
	private File input;

	public FileOperationRepository(File input) {
		this.input = input;
	}

	@Override
	public void insertAll(List<Operation> operations) {
	}

	@Override
	public List<Operation> readAll() {
		List<Operation> operations = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(input))) {
			OperationFactory factory = OperationFactory.getInstance();
			String line = br.readLine();
			while (line != null) {
				String[] tokens = line.split(",");
				String operator = tokens[0];
				String sOperands = tokens[1];
				operations.add(factory.getOperation(operator, sOperands));
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.err.println("input file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return operations;
	}
}
