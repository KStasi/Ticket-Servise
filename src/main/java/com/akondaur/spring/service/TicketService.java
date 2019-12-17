package com.akondaur.spring.service;
import java.util.List;

import com.akondaur.model.Ticket;

public interface TicketService {
    public void create(Ticket ticket);

    public List<Ticket> getAll();

    public Ticket getById(Long id);

    public void update(Ticket ticket);

    public void deleteById(Long id);
} 