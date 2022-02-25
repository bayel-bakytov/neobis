package com.example.books.repository;

import com.example.books.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
      Customer findCustomerByEmail(String email);
}
