package com.akondaur.spring.service;
import java.util.List;

import com.akondaur.model.Client;

public interface ClientService {
    public void create(Client client);

    public List<Client> getAll();

    public Client getById(Long id);

    public void update(Client client);

    public void deleteById(Long id);
} 