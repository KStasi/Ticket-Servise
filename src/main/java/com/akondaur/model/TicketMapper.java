package com.akondaur.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class TicketMapper implements RowMapper<Ticket> {

	public Ticket mapRow(ResultSet resultSet, int i) {
		Ticket ticket = new Ticket();
		try {
			ticket.setId(resultSet.getLong("id"));
			ticket.setPerformanceId(resultSet.getLong("performance_id"));
			ticket.setSeat(resultSet.getInt("seat"));
		} catch (Exception e) {
			System.out.println("Can't convert db row to object");
		}

		return ticket;
	}
}
