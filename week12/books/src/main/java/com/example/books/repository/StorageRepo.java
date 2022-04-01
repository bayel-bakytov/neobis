package com.example.books.repository;

import com.example.books.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepo  extends JpaRepository<Storage,Integer> {
}
