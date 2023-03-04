package com.app.wacknpack.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.wacknpack.model.User;
import com.app.wacknpack.persistent.UserDAO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        LOG.info("POST /user " + user);
        try {
            User result = userDAO.registerUser(user);
    
            if (result != null) {
                return new ResponseEntity<User>(result, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.CONFLICT);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/login/")
    public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
        LOG.info("GET /user/login " + email + ' ' + password);
        try {
            User result = userDAO.loginUser(email, password);
            if (result != null) {
                return new ResponseEntity<User>(result, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.CONFLICT);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        LOG.info("PUT /user/update/ " + user.getEmail());
        try {
            User result = userDAO.updateUser(user);
            if (result != null) {
                return new ResponseEntity<User>(result, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.CONFLICT);

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
