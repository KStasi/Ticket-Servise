package com.akondaur.spring.repository;
import com.akondaur.model.Performance;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Performance, Long> {

}
