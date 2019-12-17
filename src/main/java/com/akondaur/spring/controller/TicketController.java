package com.akondaur.spring.controller;
import java.util.List;

import com.akondaur.model.Ticket;
import com.akondaur.spring.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {
    @Autowired
    public TicketService ticketService;

    @GetMapping("/ticket")
    public List<Ticket> getTicketAll() {
        return ticketService.getAll();
    }

    @PostMapping("/ticket")
    public Ticket createTicket(@RequestBody
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "performance_id") Long performanceId,
            @RequestParam(value = "seat") Integer seat,
            @RequestParam(value = "date") Integer date
        ) {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        ticket.setPerformanceId(performanceId);
        ticket.setSeat(seat);
        ticket.setDate(date);

        ticketService.create(ticket);
        return ticket;
    }

    @GetMapping("/ticket/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @PutMapping("/ticket/{id}")
    public Ticket updateTicket(@PathVariable Long id,
            @RequestParam(value = "performance_id", required = false) Long performanceId,
            @RequestParam(value = "seat", required = false) Integer seat,
            @RequestParam(value = "date", required = false) Integer date
        ) {
        Ticket ticket = ticketService.getById(id);

        ticket.setPerformanceId(performanceId);
        ticket.setSeat(seat);
        ticket.setDate(date);

        ticketService.update(ticket);
        return ticket;
    }

    @DeleteMapping("/ticket/{id}")
    public Ticket deleteTicket(@PathVariable Long id) {
        Ticket ticket = ticketService.getById(id);
        ticketService.deleteById(id);
        return ticket;
    }
}
