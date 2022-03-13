package com.example.books.model;

import com.example.books.entity.Role;
import com.example.books.entity.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Data
public class Registration {
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setCity(city);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(password));
        return user;
    }
}
