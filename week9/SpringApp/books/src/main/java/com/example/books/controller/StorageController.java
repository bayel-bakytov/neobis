package com.example.books.controller;

import com.example.books.entity.Storage;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/storages")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/add-storage")
    public ResponseEntity addNewStorage(@RequestBody Storage storage) {
        try {
            storageService.add(storage);
            return ResponseEntity.ok("Storage успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-storages")
    public ResponseEntity getAllStorages() {
        try {
            return ResponseEntity.ok(storageService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findStorageById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(storageService.findById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity editStorage(@PathVariable Integer id,@RequestBody Storage storage) {
        try {
            return ResponseEntity.ok(storageService.updateEntity(id,storage));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStorage(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(storageService.deleteById(id));
        } catch (NotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
