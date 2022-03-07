package com.example.books.controller;

import com.example.books.entity.Authors;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/add-author")
    public ResponseEntity addAuthor(@RequestBody Authors authors) {
        try {
            authorService.addAuthor(authors);
            return ResponseEntity.ok("Автор успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-authors")
    public ResponseEntity getAllAuthorsModel() {
        try {
            return ResponseEntity.ok(authorService.getAllAuthors());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findAuthor(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(authorService.findOneAuthor(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editAuthor(@PathVariable Integer id,@RequestBody Authors author) {
        try {
            return ResponseEntity.ok(authorService.updateAuthor(id,author));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(authorService.deleteAuthor(id));
        } catch (NotFoundException e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
