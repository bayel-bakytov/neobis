package com.example.books.controller;

import com.example.books.dto.AuthResponse;
import com.example.books.entity.User;
import com.example.books.jwt.JwtProvider;
import com.example.books.model.UserModel;
import com.example.books.service.UserDetailsImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserDetailsImp userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody UserModel userModel) {
        try {
            User user = userService.findByLoginAndPassword(userModel.getFirstName(), userModel.getPassword());
            String token = jwtProvider.generateToken(userModel.getFirstName());
            return new ResponseEntity<AuthResponse>(new AuthResponse(token),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
