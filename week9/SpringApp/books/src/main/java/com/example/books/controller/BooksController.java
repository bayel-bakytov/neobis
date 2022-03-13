package com.example.books.controller;

import com.example.books.entity.Book;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BooksController {
    @Autowired
    private BookService bookService;

    @PostMapping("/add-book")
    public ResponseEntity addNewBook(@RequestBody Book book) {
        try {
            bookService.add(book);
            return ResponseEntity.ok("Книга успешно сохранена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-books")
    public ResponseEntity getAllBookPrices() {
        try {
            return ResponseEntity.ok(bookService.getAll());
        }catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findBookById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(bookService.findById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editBook(@PathVariable Integer id,@RequestBody Book book) {
        try {
            return ResponseEntity.ok(bookService.updateEntity(id,book));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(bookService.deleteById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
