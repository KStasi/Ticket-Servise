package com.akondaur.spring.dao;

import com.akondaur.model.Performance;
import com.akondaur.model.PerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PerformanceSearchDAO {
    JdbcTemplate jdbcTemplate;

    private final String SQL_GET_BY_TYPE = "select * from performances where type = ?";
    private final String SQL_GET_BY_THEATRE = "select * from performances where theatre like ?";
    private final String SQL_GET_ALL = "select * from performances";
    private final String SQL_GET_BY_NAME = "select * from performances where name like ?";

    @Autowired
    public PerformanceSearchDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Performance> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new PerformanceMapper());
    }

    public List<Performance> getByType(Integer type) {
        return jdbcTemplate.query(SQL_GET_BY_TYPE, new Object[] { type }, new PerformanceMapper());
    }

    public List<Performance> getByTheatre(String theatre) {
        return jdbcTemplate.query(SQL_GET_BY_THEATRE, new Object[] { theatre }, new PerformanceMapper());
    }

    public List<Performance> getByName(String name) {
        return jdbcTemplate.query(SQL_GET_BY_NAME, new Object[] { name }, new PerformanceMapper());
    }
}
