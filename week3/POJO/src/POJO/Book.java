package POJO;

import java.util.Date;

public class Book {
    private long bookId;
    private String title;
    private String author;
    private double price;
    private Category genre;
    private String imageUrl;
    private int pagesCount;
    private Date publishYear;

    public Book(){}

    public Book(long bookId,
                String title, String author,
                double price, Category genre,
                String imageUrl, int pagesCount,
                Date publishYear) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.imageUrl = imageUrl;
        this.pagesCount = pagesCount;
        this.publishYear = publishYear;
    }

    public long getId() {
        return bookId;
    }

    public void setId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public Date getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", genre=" + genre +
                ", imageUrl='" + imageUrl + '\'' +
                ", pagesCount=" + pagesCount +
                ", publishYear=" + publishYear +
                '}';
    }
}
