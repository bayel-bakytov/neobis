package com.example.books.controller;

import com.example.books.entity.Price;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @PostMapping("/add-price")
    public ResponseEntity addNewPrice(@RequestBody Price price) {
        try {
            priceService.add(price);
            return ResponseEntity.ok("Цена успешно сохранена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-prices")
    public ResponseEntity getAllBookPrices() {
        try {
            return ResponseEntity.ok(priceService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findPriceById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(priceService.findById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editPrice(@PathVariable Integer id,@RequestBody Price price) {
        try {
            return ResponseEntity.ok(priceService.updateEntity(id,price));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(priceService.deleteById(id));
        } catch (NotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
