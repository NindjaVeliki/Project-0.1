package com.github.mehrabrahman.calc.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

public class OperationRepository implements Dao<Operation> {

	@Override
	public void insert(Operation e) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Operation> readAll() {
		List<Operation> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/opsdb", "opsdb", "opsdb");) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from operations");
			while (rs.next()) {
				Operation temp;
				String[] args = new String[4];
				args[0] = rs.getString("operation");
				args[1] = rs.getString("operandA");
				args[2] = rs.getString("operandB");
				temp = OperationFactory.getInstance().getOperation(args);
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
