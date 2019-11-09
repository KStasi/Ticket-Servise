package com.akondaur.spring.dao;

import com.akondaur.model.Ticket;
import com.akondaur.model.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class TicketSearchDao {
    JdbcTemplate jdbcTemplate;

    private final String SQL_GET_BY_NAME = "select * from tickets where performance_id = ?";
    private final String SQL_GET_BY_DATE = "select * from tickets where date >= ? and date <= ?";
    private final String SQL_GET_ALL = "select * from tickets";

    @Autowired
    public TicketSearchDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Ticket> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new TicketMapper());
    }

    public List<Ticket> getByDate(Integer dateFrom, Integer dateTo) {
        return jdbcTemplate.query(SQL_GET_BY_DATE, new Object[] { dateFrom, dateTo }, new TicketMapper());
    }

    public List<Ticket> getByName(String name) {
        // should add performance
        return jdbcTemplate.query(SQL_GET_BY_NAME, new Object[] { name }, new TicketMapper());
    }
}
