package com.github.mehrabrahman.calc.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

public class SqlOperationRepository implements Dao<Operation> {
	private SqlDataSource dataSource;
	private List<Operation> cache;

	public SqlOperationRepository(SqlDataSource dataSource) {
		this.dataSource = dataSource;
		cache = new ArrayList<>();
	}

	@Override
	public void insertAll(List<Operation> operations) {
		String sql = "insert into operations(operator, operands, result) values(?, ?, ?)";
		try (Connection connection = this.dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			for (Operation operation : operations) {
				statement.setString(1, operation.getOperator());
				statement.setString(2, operation.getSOperands());
				statement.setDouble(3, operation.getResult());
				statement.addBatch();
			}
			statement.executeBatch();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public List<Operation> readAll() {
		if (cache.isEmpty()) {
			OperationFactory factory = OperationFactory.getInstance();
			String sql = "select * from operations";

			try (Connection connection = this.dataSource.getConnection();
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery(sql);) {
				while (rs.next()) {
					Operation operation;
					String operator = rs.getString("operator");
					String sOperands = rs.getString("operands");
					double result = rs.getDouble("result");
					operation = factory.getOperation(operator, sOperands);
					operation.setResult(result);
					cache.add(operation);
				}
			} catch (SQLException ex) {
				System.err.println(ex.getMessage());
			}
			return cache;
		} else {
			return cache;
		}
	}
}
