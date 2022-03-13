package com.example.books.repository;

import com.example.books.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepo extends JpaRepository<Price,Integer> {
}
