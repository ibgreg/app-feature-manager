package com.ibgreg.appfeatureuser.resources;

import com.ibgreg.appfeatureuser.entities.User;
import com.ibgreg.appfeatureuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> usersList = service.findAllUsers();

        return ResponseEntity.ok(usersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) throws Exception {
        User registeredUser = service.findUserById(id);

        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findUserByEmail(@RequestParam String email) throws Exception {
        User registeredUser = service.findUserByEmail(email);

        return ResponseEntity.ok(registeredUser);
    }
}
