package com.example.books.repository;

import com.example.books.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Authors,Integer> {
}
