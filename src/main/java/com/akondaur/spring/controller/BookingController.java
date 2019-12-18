package com.akondaur.spring.controller;
import java.lang.Iterable;
import java.util.Optional;

import com.akondaur.model.Booking;
import com.akondaur.spring.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("")
    public Iterable<Booking> getBookingAll() {
        return bookingRepository.findAll();
    }
    
    @PostMapping("")
    public Booking createBooking(@RequestBody
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "clientId") Long clientId,
            @RequestParam(value = "ticketId") Long ticketId,
            @RequestParam(value = "price") Integer price
        ) {
        Booking booking = new Booking();
        booking.setId(id);
        booking.setClientId(clientId);
        booking.setTicketId(ticketId);
        booking.setPrice(price);
    
        bookingRepository.save(booking);
        return booking;
    }
    
    @GetMapping("{id}")
    public Optional<Booking> getBooking(@PathVariable Long id) {
        return bookingRepository.findById(id);
    }
}
