package com.naresh.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.naresh.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>{


	User findByEmailAndPassword(String email, String password);

	List<User> findByEmailContainingIgnoreCase(String search);
	
	User findByName(String name);
	
	void deleteByName(String name);
	
	Optional<User> findById(String id);
	
	User findByEmail(String email);
}
