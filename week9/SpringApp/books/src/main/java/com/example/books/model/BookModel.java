package com.example.books.model;

import com.example.books.entity.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookModel {
    private Integer bookId;
    private String title;
    private Integer pagesCount;

    public BookModel() {}

    public static BookModel toModel(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.setBookId(book.getBookId());
        bookModel.setTitle(book.getTitle());
        bookModel.setPagesCount(book.getPagesCount());
        return bookModel;
    }

    public BookModel(Integer bookId, String title, Integer pagesCount) {
        this.bookId = bookId;
        this.title = title;
        this.pagesCount = pagesCount;
    }
}
