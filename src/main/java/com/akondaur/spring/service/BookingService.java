package com.akondaur.spring.service;
import java.util.List;

import com.akondaur.model.Booking;
import com.akondaur.spring.dao.BookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingDAO bookingDAO;

    public void create(Booking booking) {
        bookingDAO.create(booking);
    }

    public List<Booking> getAll() {
        return bookingDAO.getAll();
    }

    public Booking getById(Long id) {
        return bookingDAO.getById(id);
    }

    public void update(Booking booking) {
        bookingDAO.update(booking);
    }

    public void deleteById(Long id) {
        bookingDAO.deleteById(id);
    }
} 