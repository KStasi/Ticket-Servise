package com.akondaur.spring.repository;
import com.akondaur.model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {

}
