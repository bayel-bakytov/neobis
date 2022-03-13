package com.example.books.controller;

import com.example.books.entity.Customer;
import com.example.books.excepetion.CustomerException;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.CustomerModel;
import com.example.books.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity registration(@RequestBody Customer customer) {
        try {
            customerService.add(customer);
            return ResponseEntity.ok("Пользователь успешно сохранен");
       } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getCustomer(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(customerService.findById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(customerService.deleteById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity updateCustomer(@RequestParam Integer id,@RequestBody Customer customer) {
        try {
            customerService.updateEntity(id,customer);
            return new ResponseEntity(customer,HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-customers")
    public ResponseEntity<?> getAllCustomerModel() {
        try {
            return ResponseEntity.ok(customerService.getAll());
        }  catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
