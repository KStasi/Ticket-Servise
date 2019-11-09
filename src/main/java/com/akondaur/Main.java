package com.akondaur;

import com.akondaur.model.Client;
import com.akondaur.spring.config.SpringConfig;
import com.akondaur.spring.dao.ClientDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ClientDao clientDAO = context.getBean(ClientDao.class);

        Client client0 = new Client(0L, 0.5, "Sergey", "Emets", "mail");
        System.out.println(client0);
        clientDAO.create(client0);

        client0.setId(1L);
        clientDAO.create(client0);
        client0.setId(2L);
        clientDAO.create(client0);
        client0.setId(3L);
        clientDAO.create(client0);
        client0.setId(4L);
        clientDAO.create(client0);
        
        System.out.println("List of client is:");

        for (Client p : clientDAO.getAll()) {
            System.out.println(p);
        }

        System.out.println("\nGet client with ID 2");

        Client clientById = clientDAO.getById(11L);
        System.out.println(clientById);

        System.out.println("\nCreating client: ");
        Client client = new Client(4L, 0.5, "Sergey", "Emets", "mail");
        System.out.println(client);
        clientDAO.create(client);
        System.out.println("\nList of client is:");

        for (Client p : clientDAO.getAll()) {
            System.out.println(p);
        }

        System.out.println("\nDeleting client with ID 2");
        clientDAO.delete(clientById);

        System.out.println("\nUpdate client with ID 4");

        Client pclient = clientDAO.getById(4L);
        pclient.setLastName("CHANGED");
        clientDAO.update(pclient);

        System.out.println("\nList of client is:");
        for (Client p : clientDAO.getAll()) {
            System.out.println(p);
        }

        context.close();
    }
}
