package com.ticket.model;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_details")
public class Ticket {

	@Id
	@GenericGenerator(name = "tkt_id_gen", strategy = "com.ticket.repo.CustomIdGenerator")
	@GeneratedValue(generator = "tkt_id_gen", strategy = GenerationType.AUTO)
	/*
	 * @GeneratedValue(strategy =GenerationType.AUTO,generator = "tkt_id_gen")
	 * 
	 * @SequenceGenerator(name = "tkt_id_gen", sequenceName =
	 * "tkt_id_id",allocationSize = 100)
	 */
	@Column(name = "ticket_id")
	private String ticketId;

	@Column(name = "movie")
	private String movieName;
	@Column(name = "ticket_price")
	private double price;
	private int quantity;
	@Column(name = "time")
	private Date dateAndTime;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
//test
}
