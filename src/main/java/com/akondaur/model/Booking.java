package main.java.com.akondaur.model;

public class Booking {
	private Long id;
	private Long clientId;
	private Long ticketId;
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
