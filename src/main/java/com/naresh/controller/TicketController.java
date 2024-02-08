package com.naresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.model.Ticket;
import com.naresh.model.User;
import com.naresh.repo.UserRepo;
import com.naresh.repo.ticketRepo;
import com.naresh.service.TicketService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private ticketRepo ticketRepo;

	@Autowired
	private UserRepo userRepo;

	@PostMapping("/create")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
		User user = userRepo.findByEmail(ticket.getUserEmail());
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		ticket.setUserEmail(user.getEmail());
		Ticket createdTicket = ticketRepo.save(ticket);
		return ResponseEntity.ok(createdTicket);
	}

	@GetMapping("/search/{userEmail}")
	public List<Ticket> searchTickets(@RequestParam String userEmail) {
		return ticketRepo.findByUserEmailContainingIgnoreCase(userEmail);
	}


	@GetMapping("/list")
	public List<Ticket> getall(){
		return ticketRepo.findAll();
	}
	@DeleteMapping("/remove/{userEmail}")
	public void deleteByUserEmail(@PathVariable String userEmail){
		ticketRepo.deleteByUserEmail(userEmail);

	}
	@GetMapping("/close/{userEmail}")
	public List<Ticket> findByUserEmail(@RequestParam String userEmail){
		return ticketRepo.findByUserEmail(userEmail);
	}

	@GetMapping("/open")
	public ResponseEntity<List<Ticket>> getOpenTicketsByUserEmail(@RequestParam String userEmail) {
		List<Ticket> tickets = ticketService.getOpenTicketsByUserEmail(userEmail);
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{title}")
	public void deleteByTitle(@PathVariable String title) {
		ticketRepo.deleteByTitle(title);
	}

	@GetMapping("/update")
	public ResponseEntity<Ticket> getTicketById(@RequestParam String id) {
		Ticket ticket = ticketRepo.getTicketByid(id);
		if (ticket != null) {
			return ResponseEntity.ok(ticket);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/tupdate/{id}")
	public ResponseEntity<Ticket> update(@RequestBody Ticket ticket) {
		Ticket ticketupdate = ticketService.update(ticket);
		return ResponseEntity.ok(ticketupdate);
	}
}