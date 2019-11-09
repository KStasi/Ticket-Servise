package com.akondaur.spring.dao;

import com.akondaur.model.Booking;
import com.akondaur.model.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BookingSearchDao {
    JdbcTemplate jdbcTemplate;


    private final String SQL_GET_ALL = "select * from bookings";
    private final String SQL_GET_BY_CLIENT_MAIL = "select * from bookings where id = ?"; // update

    @Autowired
    public BookingSearchDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Booking getByClientEmail(String mail) {
        return jdbcTemplate.queryForObject(SQL_GET_BY_CLIENT_MAIL, new Object[] { mail }, new BookingMapper());
    }

    public List<Booking> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new BookingMapper());
    }
}
