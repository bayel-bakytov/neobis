package POJO;

public class Storage {
    private int storageId;
    private Book bookId;
    private int count;

    public Storage() {};

    public Storage(int storageId, Book bookId, int count) {
        this.storageId = storageId;
        this.bookId = bookId;
        this.count = count;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }
    @Override
    public String toString() {
        return "Storage{" +
                "bookId=" + bookId +
                ", count=" + count +
                '}';
    }
}
