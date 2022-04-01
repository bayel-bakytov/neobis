package com.example.books.repository;

import com.example.books.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByFirstName(String name);
}