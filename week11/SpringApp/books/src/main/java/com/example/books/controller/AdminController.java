package com.example.books.controller;

import com.example.books.service.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private UserDetailsImp userDetailsImp;

    @GetMapping("/admin")
    public ResponseEntity<String> getAdmin() {
        return new ResponseEntity<>("This is Admin Page!", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userDetailsImp.getAllUsers(), HttpStatus.OK);
    }
}
