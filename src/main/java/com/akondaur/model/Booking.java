package com.akondaur.model;
import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "client_id")
    private Long clientId;

    @Column (name = "ticket_id")
    private Long ticketId;

    @Column (name = "price")
    private Integer price;

    public Booking() {
    }

    public Booking(Long id, Long clientId, Long ticketId, Integer price) {
        this.id = id;
        this.clientId = clientId;
        this.ticketId = ticketId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", clientId=" + clientId + ", ticketId='" + ticketId + '\'' + ", price='" + price
                + '\'' + '}';
    }
}
