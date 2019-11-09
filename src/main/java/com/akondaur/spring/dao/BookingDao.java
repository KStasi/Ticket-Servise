package main.java.com.akondaur.spring.dao;

import main.java.com.akondaur.model.Booking;
import main.java.com.akondaur.model.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BookingDao implements DbObjectDaoGeneric<Booking>{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND = "select * from bookings where id = ?";
    private final String SQL_DELETE = "delete from bookings where id = ?";
    private final String SQL_UPDATE = "update bookings set client_id = ?, ticket_id = ?, price = ? where id = ?";
    private final String SQL_GET_ALL = "select * from bookings";
    private final String SQL_INSERT = "insert into bookings(id, client_id, ticket_id, price) values(?,?,?,?)";

    @Autowired
    public BookingDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Booking getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new BookingMapper());
    }

    public List<Booking> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new BookingMapper());
    }

    public boolean delete(Booking booking) {
        return jdbcTemplate.update(SQL_DELETE, booking.getId()) > 0;
    }

    public boolean update(Booking booking) {
        return jdbcTemplate.update(SQL_UPDATE, booking.getClientId(), booking.getTicketId(), booking.getPrice(),
                booking.getId()) > 0;
    }

    public boolean create(Booking booking) {
        return jdbcTemplate.update(SQL_INSERT, booking.getId(), booking.getClientId(), booking.getTicketId(), booking.getPrice()) > 0;
    }
}
