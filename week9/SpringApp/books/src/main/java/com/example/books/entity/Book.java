package com.example.books.entity;

import lombok.*;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "author_id")
    private Authors authorId;
    @OneToOne
    @JoinColumn(name = "price_id",referencedColumnName = "price_id")
    private Price priceId;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Category genreId;
    @Column(name = "pages_count")
    private Integer pagesCount;

    public Book(String title, Authors authorId, Price priceId, Category genreId) {
        this.title = title;
        this.authorId = authorId;
        this.priceId = priceId;
        this.genreId = genreId;
    }
}