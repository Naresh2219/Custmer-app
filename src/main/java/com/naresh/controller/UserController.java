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

import com.naresh.model.User;
import com.naresh.repo.UserRepo;
import com.naresh.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserService service;
	
	@Autowired
	private UserRepo repo;

    
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return repo.save(user);
    }
    
    @PostMapping("/Login")
    public ResponseEntity<Object> login(@RequestBody User user) {
        try {
            User loggedInUser = service.logIn(user);
            if (loggedInUser != null) {
                return ResponseEntity.ok(loggedInUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process login");
        }
    }
    
  
    @GetMapping("/all")
    public List<User> getAllUsers() {
       return repo.findAll();
        
    }
    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String search) {
        return repo.findByEmailContainingIgnoreCase(search);
    }
    

    @PutMapping("/update/{name}")
    public ResponseEntity<User> update(@RequestBody User user) {
        User updatedUser = service.update(user);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/delete/{name}")
    public void deleteByName(@PathVariable String name) {
        repo.deleteByName(name);
    }

    @GetMapping("/get/{name}")
    public User findByName(@PathVariable String name) {
    	return repo.findByName(name);
    }
    
}
    

