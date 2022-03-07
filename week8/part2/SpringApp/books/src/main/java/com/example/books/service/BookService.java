package com.example.books.service;

import com.example.books.entity.Book;
import com.example.books.entity.Price;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.BookModel;
import com.example.books.model.PriceModel;
import com.example.books.repository.BookRepo;
import com.example.books.repository.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public List<BookModel> convertPriceToModel(Iterable<Book> books) {
        List<BookModel> bookModelList = new ArrayList<>();
        for (Book book : books)
        {
            bookModelList.add(BookModel.toModel(book));
        }
        return bookModelList;
    }

    public List<BookModel> getAllBooks() {
        return convertPriceToModel(bookRepo.findAll());
    }

    public BookModel findOneBook(Integer id) throws NotFoundException {
        Book book = bookRepo.findById(id).get();
        if (book == null) {
            throw new NotFoundException("Книга не найдена");
        }
        return BookModel.toModel(book);
    }

    public int deleteBook(Integer id) throws NotFoundException {
        if (!bookRepo.existsById(id)) {
            throw new NotFoundException("книга не найдена");
        }
        bookRepo.deleteById(id);
        return id;
    }

    public Book updateBook(Integer id, Book model) throws NotFoundException {
        if (!bookRepo.existsById(id)) {
            throw new NotFoundException("Книга не найдена");
        }
        Book book = bookRepo.findById(id).get();
        book.setTitle(model.getTitle());
        book.setAuthorId(model.getAuthorId());
        book.setBookId(model.getBookId());
        book.setPagesCount(model.getPagesCount());
        return bookRepo.save(book);
    }

}
