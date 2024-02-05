package com.ticket.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.model.Ticket;
import com.ticket.service.ITicketServie;

@RestController
public class TicketController {

	@Autowired
	private ITicketServie iTicketServie;

	@GetMapping(value = "/test")
	public String testMVC() {

		return "Home";
	}

	@PostMapping(value = "/createTicket")
	public Ticket addTicket(@RequestBody Ticket ticket) {

		Ticket tktresponse = iTicketServie.addTicket(ticket);

		return tktresponse;
	}

	@GetMapping(value = "/getALlTicket")
	public List<Ticket> getALlTicket() {

		List<Ticket> allTicket = iTicketServie.getALlTicket();

		return allTicket;
	}

	//

	@GetMapping(value = "/findById/{tktId}")
	public Ticket getTicketById(@PathVariable String tktId) {

		Optional<Ticket> ticket = iTicketServie.getTicketById(tktId);

		return ticket.get();
	}

	@DeleteMapping(value = "/deleteTicket/{tktId}")
	public void deleteTicket(@PathVariable String tktId) {

		iTicketServie.deleteTicket(tktId);
	}

	@PutMapping(value = "/updateTicket")
	public String updateTicket(@RequestBody Ticket ticket) {
		Ticket tkt = iTicketServie.updateTicket(ticket);

		return "Ticket is Updated with Id" + tkt.getTicketId();
	}

	@GetMapping(value = "/getByMovieName/{movieName}")
	public Ticket getTicketByMovieName(@PathVariable String movieName) {

		Ticket tk = iTicketServie.getTicketByMovieName(movieName);
		return tk;
	}

	
	@GetMapping(value = "/byPrice/{price}")
	public List<Ticket> getByPrice( @PathVariable double price) {
	     
		List<Ticket> ticketList =iTicketServie.getByPrice(price);
		
		return ticketList;
	}
	

}
