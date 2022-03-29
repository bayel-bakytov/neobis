package com.example.books.controller;

import com.example.books.entity.Order;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add-order")
    public ResponseEntity addNewOrder(@RequestBody Order order) {
        try {
            orderService.add(order);
            return ResponseEntity.ok("Заказ успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-orders")
    public ResponseEntity getAllOrders() {
        try {
            return ResponseEntity.ok(orderService.getAll());
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findOrderById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(orderService.findById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editOrder(@PathVariable Integer id,@RequestBody Order order) {
        try {
            return ResponseEntity.ok(orderService.updateEntity(id,order));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(orderService.deleteById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
