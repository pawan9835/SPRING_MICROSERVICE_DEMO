package com.ticket.service;

import java.util.List;
import java.util.Optional;

import com.ticket.model.Ticket;

public interface ITicketServie {
	
	
	public Ticket addTicket(Ticket ticket);
	
	public List<Ticket> getALlTicket();
	
	
	public Optional<Ticket> getTicketById(String tktId);
	
	public void deleteTicket(String tktId);
	
	public Ticket updateTicket(Ticket ticket);
	
	public Ticket getTicketByMovieName(String movieName);
	
	public List<Ticket> getByPrice(double price);
	
	
	
	

}
