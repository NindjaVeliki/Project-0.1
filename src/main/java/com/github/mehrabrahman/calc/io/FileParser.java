package com.github.mehrabrahman.calc.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.github.mehrabrahman.calc.math.Add;
import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.Outputtable;

public class FileParser {
	static File history = new File("history.txt");
	
	public static void write(Outputtable operation) {
		// Print to file
		try (FileWriter fw = new FileWriter(history, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);) {

			pw.println(operation.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void read(List<Outputtable> operations) {
		// Read from file
		try (FileReader in = new FileReader(history); BufferedReader br = new BufferedReader(in);) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				operations.add(new Add("add", "2", "2"));
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
