package com.akondaur.spring.controller;
import java.lang.Iterable;
import java.util.Optional;

import com.akondaur.model.Ticket;
import com.akondaur.spring.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("")
    public Iterable<Ticket> getBookingAll() {
        return ticketRepository.findAll();
    }
    
    @PostMapping("")
    public Ticket createBooking(@RequestBody
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "performanceId") Long performanceId,
            @RequestParam(value = "seat") Integer seat,
            @RequestParam(value = "date") Integer date
        ) {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        ticket.setPerformanceId(performanceId);
        ticket.setSeat(seat);
        ticket.setDate(date);
    
        ticketRepository.save(ticket);
        return ticket;
    }
    
    @GetMapping("{id}")
    public Optional<Ticket> getBooking(@PathVariable Long id) {
        return ticketRepository.findById(id);
    }
}
