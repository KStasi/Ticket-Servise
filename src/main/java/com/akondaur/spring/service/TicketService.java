package com.akondaur.spring.service;
import java.util.List;

import com.akondaur.model.Ticket;
import com.akondaur.spring.dao.TicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketDAO ticketDAO;

    public void create(Ticket ticket) {
        ticketDAO.create(ticket);
    }

    public List<Ticket> getAll() {
        return ticketDAO.getAll();
    }

    public Ticket getById(Long id) {
        return ticketDAO.getById(id);
    }

    public void update(Ticket ticket) {
        ticketDAO.update(ticket);
    }

    public void deleteById(Long id) {
        ticketDAO.deleteById(id);
    }
} 