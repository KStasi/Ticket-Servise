package com.akondaur.spring.dao;
import java.util.List;

import javax.sql.DataSource;

import com.akondaur.model.Client;
import com.akondaur.model.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientDao implements DbObjectDaoGeneric<Client>{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND = "select * from clients where id = ?";
    private final String SQL_DELETE = "delete from clients where id = ?";
    private final String SQL_UPDATE = "update clients set discount = ?, firstName = ?, lastName = ?, email = ? where id = ?";
    private final String SQL_GET_ALL = "select * from clients";
    private final String SQL_INSERT = "insert into clients(id, discount, first_name, last_name, email) values(?,?,?,?,?)";

    @Autowired
    public ClientDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Client getById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id }, new ClientMapper());
    }

    public List<Client> getAll() {
        return jdbcTemplate.query(SQL_GET_ALL, new ClientMapper());
    }

    public boolean delete(Client client) {
        return jdbcTemplate.update(SQL_DELETE, client.getId()) > 0;
    }

    public boolean update(Client client) {
        return jdbcTemplate.update(SQL_UPDATE, client.getDiscount() , client.getFirstName(), client.getLastName(), client.getEmail(),
                client.getId()) > 0;
    }

    public boolean create(Client client) {
        return jdbcTemplate.update(SQL_INSERT, client.getId(), client.getDiscount(), client.getFirstName(), client.getLastName(),
                client.getEmail()) > 0;
    }
}
