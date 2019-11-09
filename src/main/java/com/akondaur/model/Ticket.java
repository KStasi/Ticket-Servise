package com.akondaur.model;

public class Ticket {
	private Long id;
	private Long performanceId;
	private Integer seat;

	public Ticket() {
	}

	public Ticket(Long id, Long performanceId, Integer seat) {
		this.id = id;
		this.performanceId = performanceId;
		this.seat = seat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(Long performanceId) {
		this.performanceId = performanceId;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Ticket{" + "id=" + id + ", performanceId=" + performanceId + ", seat='" + seat + '\'' + '}';
	}
}
