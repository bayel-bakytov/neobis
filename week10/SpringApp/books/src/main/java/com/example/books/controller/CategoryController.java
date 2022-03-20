package com.example.books.controller;

import com.example.books.entity.Category;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add-category")
    public ResponseEntity addNewCategory(@RequestBody Category category) {
        try {
            categoryService.add(category);
            return ResponseEntity.ok("Категория успешно сохранена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-categories")
    public ResponseEntity getAllCategories() {
        try {
            return ResponseEntity.ok(categoryService.getAll());
        }  catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("find/{id}")
    public ResponseEntity findCategory(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(categoryService.findById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editCategory(@PathVariable Integer id,@RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.updateEntity(id,category));
        }  catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(categoryService.deleteById(id));
        }  catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
