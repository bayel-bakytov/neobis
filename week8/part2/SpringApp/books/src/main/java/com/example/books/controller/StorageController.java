package com.example.books.controller;

import com.example.books.entity.Storage;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storages")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/add-storage")
    public ResponseEntity addNewStorage(@RequestBody Storage storage) {
        try {
            storageService.addStorage(storage);
            return ResponseEntity.ok("Storage успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-storages")
    public ResponseEntity getAllStorages() {
        try {
            return ResponseEntity.ok(storageService.getAllStorages());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity findStorageById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(storageService.findOneStorage(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity editStorage(@PathVariable Integer id,@RequestBody Storage storage) {
        try {
            return ResponseEntity.ok(storageService.updateStorage(id,storage));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStorage(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(storageService.deleteStorage(id));
        } catch (NotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
