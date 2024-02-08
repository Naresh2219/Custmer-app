package com.naresh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.model.Ticket;
import com.naresh.repo.ticketRepo;

@Service
public class TicketService {

	@Autowired
	private ticketRepo ticketRepo;

	public List<Ticket> getOpenTicketsByUserEmail(String userEmail) {
		return ticketRepo.findByUserEmail(userEmail);
	}
	public void deleteByTitle(String title) {
		ticketRepo.deleteByTitle(title);
	}
//			public Ticket update(Ticket ticket) {
//				return ticketRepo.save(ticket);
//			}
//	public Ticket update(Ticket updatedTicket) {
//		Optional<Ticket> existingTicket = ticketRepo.findById(updatedTicket.getId());
//
//		if (existingTicket.isPresent()) {
//			Ticket ticketToUpdate = existingTicket.get();
//			ticketToUpdate.setTitle(updatedTicket.getTitle());
//			ticketToUpdate.setDescription(updatedTicket.getDescription());
//			ticketToUpdate.setStatus(updatedTicket.getStatus());
//
//			return ticketRepo.save(ticketToUpdate);
//		} else {
//			return null; 
//		}
//	}
		public Ticket update( Ticket ticket) {
			return ticketRepo.save(ticket);
		}
}



