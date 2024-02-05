package com.ticket.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticket.model.Ticket;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket,Serializable>{
	
	 public Ticket findByMovieName(String movieName);
	 
	 public List<Ticket> findByPrice(double price);
	 
	 
	 @Query("select tk from Ticket tk where tk.price =?1")
	 public List<Ticket> getTicketByPrice(double price);
	 
	 
	 
	 

} 
