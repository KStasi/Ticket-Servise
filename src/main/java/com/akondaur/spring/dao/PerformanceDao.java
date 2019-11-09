package main.java.com.akondaur.spring.dao;

import main.java.com.akondaur.model.Performance;
import main.java.com.akondaur.model.PerformanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PerformanceDao implements DbObjectDaoGeneric<Performance>{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND = "select * from performances where id = ?";
    private final String SQL_DELETE = "delete from performances where id = ?";
    private final String SQL_UPDATE = "update performances set name = ?, description = ?, type = ?, theatre = ? where id = ?";
    private final String SQL_GET_ALL = "select * from performances";
    private final String SQL_INSERT = "insert into performances(id, name, description, type, theatre) values(?,?,?,?,?)";

    @Autowired
    public PerformanceDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Performance getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new PerformanceMapper());
    }

    public List<Performance> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new PerformanceMapper());
    }

    public boolean delete(Performance performance) {
        return jdbcTemplate.update(SQL_DELETE, performance.getId()) > 0;
    }

    public boolean update(Performance performance) {
        return jdbcTemplate.update(SQL_UPDATE, performance.getName() , performance.getDescription(), performance.getType(), performance.getTheatre(),
                performance.getId()) > 0;
    }

    public boolean create(Performance performance) {
        return jdbcTemplate.update(SQL_INSERT, performance.getId(), performance.getName() , performance.getDescription(), performance.getType(), performance.getTheatre()) > 0;
    }
}
