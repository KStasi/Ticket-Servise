package com.akondaur.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ClientMapper implements RowMapper<Client> {

    public Client mapRow(ResultSet resultSet, int i) {
        Client client = new Client();
        try {
            client.setId(resultSet.getLong("id"));
            client.setFirstName(resultSet.getString("first_name"));
            client.setLastName(resultSet.getString("last_name"));
            client.setDiscount(resultSet.getDouble("discount"));
            client.setEmail(resultSet.getString("email"));
        } catch (Exception e) {
            System.out.println("Can't convert db row to object");
        }

        return client;
    }
}
