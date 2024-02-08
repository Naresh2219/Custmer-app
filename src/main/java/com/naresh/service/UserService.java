package com.naresh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naresh.model.User;
import com.naresh.repo.UserRepo;
import com.naresh.service.UserService;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User logIn(User user) {
        User loggedInUser = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return loggedInUser;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public void deleteByName(String name) {
        repo.deleteById(name);
    }

    public User update(User user) {
        return repo.save(user);
    }
}
