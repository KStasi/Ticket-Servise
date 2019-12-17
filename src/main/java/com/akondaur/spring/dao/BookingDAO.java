package com.akondaur.spring.dao;

import com.akondaur.model.Booking;
import com.akondaur.model.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BookingDAO implements DbObjectDAOGeneric<Booking>{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND = "select * from bookings where id = ?";
    private final String SQL_DELETE = "delete from bookings where id = ?";
    private final String SQL_UPDATE = "update bookings set client_id = ?, ticket_id = ?, price = ? where id = ?";
    private final String SQL_GET_ALL = "select * from bookings";
    private final String SQL_INSERT = "insert into bookings(client_id, ticket_id, price) values(?,?,?)";

    @Autowired
    public BookingDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Booking getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new BookingMapper());
    }

    public List<Booking> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new BookingMapper());
    }

    public boolean deleteById(Long id) {
        return jdbcTemplate.update(SQL_DELETE, id) > 0;
    }

    public boolean update(Booking booking) {
        return jdbcTemplate.update(SQL_UPDATE, booking.getClientId(), booking.getTicketId(), booking.getPrice(),
                booking.getId()) > 0;
    }

    public boolean create(Booking booking) {
        return jdbcTemplate.update(SQL_INSERT, booking.getClientId(), booking.getTicketId(), booking.getPrice()) > 0;
    }
}
