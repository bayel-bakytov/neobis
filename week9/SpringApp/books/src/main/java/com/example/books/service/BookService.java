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
public class BookService implements Crud <Book,BookModel,Integer>{
    @Autowired
    private BookRepo bookRepo;

    @Override
    public void add(Book book) {
         bookRepo.save(book);
    }

    @Override
    public List<BookModel> convertToModel(Iterable<Book> books) {
        List<BookModel> bookModelList = new ArrayList<>();
        for (Book book : books)
        {
            bookModelList.add(BookModel.toModel(book));
        }
        return bookModelList;
    }

    @Override
    public List<BookModel> getAll() throws NotFoundException {
        return convertToModel(bookRepo.findAll());
    }

    @Override
    public BookModel findById(Integer id) throws NotFoundException {
        Book book = bookRepo.findById(id).get();
        if (book == null) {
            throw new NotFoundException("Книга не найдена");
        }
        return BookModel.toModel(book);
    }

    @Override
    public int deleteById(Integer id) throws NotFoundException {
        if (!bookRepo.existsById(id)) {
            throw new NotFoundException("книга не найдена");
        }
        bookRepo.deleteById(id);
        return id;
    }

    @Override
    public Book updateEntity(Integer id, Book bookModel) throws NotFoundException {
        if (!bookRepo.existsById(id)) {
            throw new NotFoundException("Книга не найдена");
        }
        Book book = bookRepo.findById(id).get();
        book.setTitle(bookModel.getTitle());
        book.setAuthorId(bookModel.getAuthorId());
        book.setBookId(bookModel.getBookId());
        book.setPagesCount(bookModel.getPagesCount());
        return bookRepo.save(book);
    }
}
