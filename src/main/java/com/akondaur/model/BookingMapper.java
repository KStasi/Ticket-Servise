package main.java.com.akondaur.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class BookingMapper implements RowMapper<Booking> {

	public Booking mapRow(ResultSet resultSet, int i) {
		Booking booking = new Booking();
		try {
			booking.setId(resultSet.getLong("id"));
			booking.setClientId(resultSet.getLong("client_id"));
			booking.setTicketId(resultSet.getLong("ticket_id"));
			booking.setPrice(resultSet.getInt("price"));
		} catch (Exception e) {
			System.out.println("Can't convert db row to object");
		}

		return booking;
	}
}
