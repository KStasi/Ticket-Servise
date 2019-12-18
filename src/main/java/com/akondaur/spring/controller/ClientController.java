package com.akondaur.spring.controller;
import java.lang.Iterable;
import java.util.Optional;

import com.akondaur.model.Client;
import com.akondaur.spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("")
    public Iterable<Client> getBookingAll() {
        return clientRepository.findAll();
    }
    
    @PostMapping("")
    public Client createBooking(@RequestBody
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName") String lastName,
            @RequestParam(value = "price") Double discount,
            @RequestParam(value = "email") String email
        ) {
        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setDiscount(discount);
        client.setEmail(email);
    
        clientRepository.save(client);
        return client;
    }
    
    @GetMapping("{id}")
    public Optional<Client> getBooking(@PathVariable Long id) {
        return clientRepository.findById(id);
    }
}
