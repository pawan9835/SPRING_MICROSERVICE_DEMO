package com.ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.model.Ticket;
import com.ticket.repo.TicketRepository;

@Service
public class TicketServieImpl implements ITicketServie {

	@Autowired
	private TicketRepository ticketRepo;

	@Override
	public Ticket addTicket(Ticket ticket) {

		return ticketRepo.save(ticket);
	}

	@Override
	public List<Ticket> getALlTicket() {
		return ticketRepo.findAll();

	}

	@Override
	public Optional<Ticket> getTicketById(String tktId) {

		Optional<Ticket> ticket = ticketRepo.findById(tktId);
		return ticket;
	}

	@Override
	public void deleteTicket(String tktId) {

		ticketRepo.deleteById(tktId);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		Ticket ticketResponse = null;
		if (ticket != null) {

			Optional<Ticket> OptObj = ticketRepo.findById(ticket.getTicketId());

			Ticket tktValue = OptObj.get();

			tktValue.setTicketId(ticket.getTicketId());
			tktValue.setPrice(ticket.getPrice());
			tktValue.setMovieName(ticket.getMovieName());
			tktValue.setDateAndTime(ticket.getDateAndTime());

			ticketResponse = ticketRepo.save(tktValue);

		}

		return ticketResponse;
	}
	
	@Override
	public Ticket getTicketByMovieName(String movieName) {
		
		Ticket tk =    ticketRepo.findByMovieName(movieName);
		return tk;
	}
	
@Override
public List<Ticket> getByPrice(double price) {
     
	List<Ticket> ticketList =ticketRepo.getTicketByPrice(price);
	
	return ticketList;
}

	
}
