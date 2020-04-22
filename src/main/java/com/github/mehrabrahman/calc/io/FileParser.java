package com.github.mehrabrahman.calc.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

public class FileParser implements Dao<Operation> {
	static final File input = new File("input.csv");
	static final File output = new File("output.csv");
	
	private void write(Operation operation) {
		// Print to file
		try (FileWriter fw = new FileWriter(output, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) {
			pw.println(operation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Operation> read() {
		// Read from file
		List<Operation> result = new ArrayList<>(); 
		try (FileReader in = new FileReader(input); BufferedReader br = new BufferedReader(in);) {
			String line = br.readLine();
			OperationFactory factory = OperationFactory.getInstance();
			while (line != null) {
				String[] args = line.split(",");
				result.add(factory.getOperation(args));
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(Operation operation) {
		write(operation);		
	}

	@Override
	public List<Operation> readAll() {
		return read();
	}

}
