package com.akondaur.spring.controller;
import java.util.List;

import com.akondaur.model.Booking;
import com.akondaur.spring.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {
    @Autowired
    public BookingService bookingService;

    @GetMapping("/booking")
    public List<Booking> getBookingAll() {
        return bookingService.getAll();
    }

    @PostMapping("/booking")
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

        bookingService.create(booking);
        return booking;
    }

    @GetMapping("/booking/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingService.getById(id);
    }

    @PutMapping("/booking/{id}")
    public Booking updateBooking(@PathVariable Long id,
            @RequestParam(value = "clientId", required = false) Long clientId,
            @RequestParam(value = "ticketId", required = false) Long ticketId,
            @RequestParam(value = "price", required = false) Integer price
        ) {
        Booking booking = bookingService.getById(id);

        booking.setClientId(clientId);
        booking.setTicketId(ticketId);
        booking.setPrice(price);

        bookingService.update(booking);
        return booking;
    }

    @DeleteMapping("/booking/{id}")
    public Booking deleteBooking(@PathVariable Long id) {
        Booking booking = bookingService.getById(id);
        bookingService.deleteById(id);
        return booking;
    }
}
