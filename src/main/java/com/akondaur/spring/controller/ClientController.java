package com.akondaur.spring.controller;
import java.util.List;

import com.akondaur.model.Client;
import com.akondaur.spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    public ClientService clientService;

    @GetMapping("/client")
    public List<Client> getClientAll() {
        return clientService.getAll();
    }

    @PostMapping("/client")
    public Client createClient(@RequestBody
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "discount") Double discount,
            @RequestParam(value = "first_name") String firstName,
            @RequestParam(value = "last_name") String lastName,
            @RequestParam(value = "email") String email
        ) {
        Client client = new Client();
        client.setId(id);
        client.setDiscount(discount);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        clientService.create(client);
        return client;
    }

    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @PutMapping("/client/{id}")
    public Client updateClient(@PathVariable Long id,
            @RequestParam(value = "discount", required = false) Double discount,
            @RequestParam(value = "first_name", required = false) String firstName,
            @RequestParam(value = "last_name", required = false) String lastName,
            @RequestParam(value = "email", required = false) String email
        ) {
        Client client = clientService.getById(id);

        client.setDiscount(discount);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        clientService.update(client);
        return client;
    }

    @DeleteMapping("/client/{id}")
    public Client deleteClient(@PathVariable Long id) {
        Client client = clientService.getById(id);
        clientService.deleteById(id);
        return client;
    }
}
