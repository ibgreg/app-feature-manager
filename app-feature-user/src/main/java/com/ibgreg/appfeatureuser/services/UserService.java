package com.ibgreg.appfeatureuser.services;

import com.ibgreg.appfeatureuser.entities.User;
import com.ibgreg.appfeatureuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findUserById(Long id) throws Exception {

        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new Exception(
                "User not found!"));
    }

    public User findUserByEmail(String email) throws Exception {

        User user = repository.findByEmail(email);

        if (user == null) {
            throw new IllegalArgumentException("Email not found");
        }

        return user;
    }
}
