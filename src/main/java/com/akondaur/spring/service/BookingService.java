package com.akondaur.spring.service;
import java.util.List;

import com.akondaur.model.Booking;

public interface BookingService {
    public void create(Booking booking);

    public List<Booking> getAll();

    public Booking getById(Long id);

    public void update(Booking booking);

    public void deleteById(Long id);
} 