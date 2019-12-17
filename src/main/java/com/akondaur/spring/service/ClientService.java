package com.akondaur.spring.service;
import java.util.List;

import com.akondaur.model.Client;
import com.akondaur.spring.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientDAO clientDAO;

    public void create(Client client) {
        clientDAO.create(client);
    }

    public List<Client> getAll() {
        return clientDAO.getAll();
    }

    public Client getById(Long id) {
        return clientDAO.getById(id);
    }

    public void update(Client client) {
        clientDAO.update(client);
    }

    public void deleteById(Long id) {
        clientDAO.deleteById(id);
    }
} 