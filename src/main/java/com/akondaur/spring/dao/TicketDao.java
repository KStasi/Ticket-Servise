package main.java.com.akondaur.spring.dao;

import main.java.com.akondaur.model.Ticket;
import main.java.com.akondaur.model.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class TicketDao implements DbObjectDaoGeneric<Ticket>{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND = "select * from tickets where id = ?";
    private final String SQL_DELETE = "delete from tickets where id = ?";
    private final String SQL_UPDATE = "update tickets set performance_id = ?, seat = ? where id = ?";
    private final String SQL_GET_ALL = "select * from tickets";
    private final String SQL_INSERT = "insert into tickets(id, performance_id, seat) values(?,?,?)";

    @Autowired
    public TicketDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Ticket getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new TicketMapper());
    }

    public List<Ticket> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new TicketMapper());
    }

    public boolean delete(Ticket ticket) {
        return jdbcTemplate.update(SQL_DELETE, ticket.getId()) > 0;
    }

    public boolean update(Ticket ticket) {
        return jdbcTemplate.update(SQL_UPDATE, ticket.getPerformanceId() , ticket.getSeat(),
                ticket.getId()) > 0;
    }

    public boolean create(Ticket ticket) {
        return jdbcTemplate.update(SQL_INSERT, ticket.getId(), ticket.getPerformanceId() , ticket.getSeat()) > 0;
    }
}
