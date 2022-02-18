package com.example.books.repository;

import com.example.books.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customer,Integer> {
      Customer findCustomerByEmail(String email);
}
