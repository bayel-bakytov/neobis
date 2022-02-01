package POJO;

import java.util.Date;

public class Book {
    private long bookId;
    private String title;
    private Author authorId;
    private Price priceId;
    private Category genreId;
    private String imageUrl;
    private int pagesCount;
    private Date publishYear;

    public Book(){}

    public Book(long bookId,
                String title, Author authorId,
                Price priceId, Category genreId,
                String imageUrl, int pagesCount,
                Date publishYear) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.priceId = priceId;
        this.genreId = genreId;
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

    public Author getAuthor() {
        return authorId;
    }

    public void setAuthor(Author authorId) {
        this.authorId = authorId;
    }

    public Price getPrice() {
        return priceId;
    }

    public void setPrice(Price priceId) {
        this.priceId = priceId;
    }

    public Category getGenre() {
        return genreId;
    }

    public void setGenre(Category genre) {
        this.genreId = genre;
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
                ", authorId='" + authorId + '\'' +
                ", priceId=" + priceId +
                ", genreId=" + genreId +
                ", imageUrl='" + imageUrl + '\'' +
                ", pagesCount=" + pagesCount +
                ", publishYear=" + publishYear +
                '}';
    }
}
