package main.java.com.akondaur.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class PerformanceMapper implements RowMapper<Performance> {

	public Performance mapRow(ResultSet resultSet, int i) {
		Performance performance = new Performance();
		try {
			performance.setId(resultSet.getLong("id"));
			performance.setName(resultSet.getString("name"));
			performance.setDescription(resultSet.getString("description"));
			performance.setType(resultSet.getInt("type"));
			performance.setTheatre(resultSet.getString("theatre"));
		} catch (Exception e) {
			System.out.println("Can't convert db row to object");
		}

		return performance;
	}
}
