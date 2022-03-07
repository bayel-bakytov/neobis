package com.example.books.controller;

import com.example.books.entity.Price;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @PostMapping("/add-price")
    public ResponseEntity addNewPrice(@RequestBody Price price) {
        try {
            priceService.addPrice(price);
            return ResponseEntity.ok("Цена успешно сохранена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-prices")
    public ResponseEntity getAllBookPrices() {
        try {
            return ResponseEntity.ok(priceService.getAllPrices());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity findPriceById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(priceService.findOnePrice(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity editPrice(@PathVariable Integer id,@RequestBody Price price) {
        try {
            return ResponseEntity.ok(priceService.updatePrice(id,price));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(priceService.deletePrice(id));
        } catch (NotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
