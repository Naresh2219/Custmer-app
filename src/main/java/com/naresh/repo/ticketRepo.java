package com.naresh.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.naresh.model.Ticket;
@Repository
public interface ticketRepo extends MongoRepository<Ticket, String>{
	
	//List<Ticket> findByUserIdAndStatus(String email, String status);
	
	//List<Ticket> findByUserId(String id);
	
	//List<Ticket> findByUserEmail(String userEmail);

	//List<Ticket> updateByEmail(String email);
	List<Ticket> findByUserEmail(String userEmail);
	
	 //List<Ticket> findByUserEmailOrTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String userEmail, String title, String description);

	List<Ticket> findByUserEmailContainingIgnoreCase(String search);

	
    void deleteByUserEmail(String userEmail);

	//List<Ticket> deletebytitle(String title);

	void deleteByTitle(String title);

	Ticket getTicketByid(String id);

	//Ticket save(Ticket ticket);
    
  //public Ticket findByUserEmail(String userEmail);
    
   //Ticket countByUserEmail(String userEmail);
}
