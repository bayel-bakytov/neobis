package com.example.books.controller;

import com.example.books.entity.Order;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add-order")
    public ResponseEntity addNewOrder(@RequestBody Order order) {
        try {
            orderService.addOrder(order);
            return ResponseEntity.ok("Заказ успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-orders")
    public ResponseEntity getAllOrders() {
        try {
            return ResponseEntity.ok(orderService.getAllOrders());
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity findOrderById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(orderService.findOneOrder(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editOrder(@PathVariable Integer id,@RequestBody Order order) {
        try {
            return ResponseEntity.ok(orderService.updateOrder(id,order));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(orderService.deleteOrder(id));
        } catch (NotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
