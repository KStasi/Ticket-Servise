package com.akondaur.spring.dao;

import com.akondaur.model.Ticket;
import com.akondaur.model.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class TicketDAO implements DbObjectDAOGeneric<Ticket>{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND = "select * from tickets where id = ?";
    private final String SQL_DELETE = "delete from tickets where id = ?";
    private final String SQL_UPDATE = "update tickets set performance_id = ?, seat = ?, date = ? where id = ?";
    private final String SQL_GET_ALL = "select * from tickets";
    private final String SQL_INSERT = "insert into tickets(performance_id, seat, date) values(?,?,?)";

    @Autowired
    public TicketDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Ticket getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new TicketMapper());
    }

    public List<Ticket> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new TicketMapper());
    }

    public boolean deleteById(Long id) {
        return jdbcTemplate.update(SQL_DELETE, id) > 0;
    }

    public boolean update(Ticket ticket) {
        return jdbcTemplate.update(SQL_UPDATE, ticket.getPerformanceId() , ticket.getSeat(), ticket.getDate(),
                ticket.getId()) > 0;
    }

    public boolean create(Ticket ticket) {
        return jdbcTemplate.update(SQL_INSERT, ticket.getPerformanceId() , ticket.getSeat(), ticket.getDate()) > 0;
    }
}
