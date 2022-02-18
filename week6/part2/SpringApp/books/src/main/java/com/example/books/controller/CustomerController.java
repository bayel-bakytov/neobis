package com.example.books.controller;

import com.example.books.entity.Customer;
import com.example.books.excepetion.CustomerException;
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
            customerService.addCustomer(customer);
            return ResponseEntity.ok("Пользователь успешно сохранен");
       } catch (CustomerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getCustomer(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(customerService.findOneCustomer(id));
        } catch (CustomerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(customerService.deleteCustomer(id));
        } catch (CustomerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id,@RequestBody CustomerModel customer) {
        try {
            customerService.updateCustomer(id,customer);
            return new ResponseEntity(customer,HttpStatus.OK);
        } catch (CustomerException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-customers")
    public ResponseEntity<?> getAllCustomerModel() {
        try {
            return ResponseEntity.ok(customerService.getAllCustomers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
