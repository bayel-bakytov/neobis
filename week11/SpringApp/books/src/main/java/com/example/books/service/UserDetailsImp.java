package com.example.books.service;

import com.example.books.entity.User;
import com.example.books.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsServiceImpl")
public class UserDetailsImp implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByFirstName(username);
    }

    public User findByFirstName(String firstName) {
        return userRepo.findByFirstName(firstName);
    }

    public User findByLoginAndPassword(String firstName, String password) {
        User userEntity = findByFirstName(firstName);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
       return userRepo.findAll();
    }
}
