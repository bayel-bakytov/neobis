package entity;

public class Storage {
    private int storageId;
    private int bookId;
    private int countBook;

    public Storage(int storageId, int bookId, int countBook) {
        this.storageId = storageId;
        this.bookId = bookId;
        this.countBook = countBook;
    }

    public Storage() {
    }

    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCountBook() {
        return countBook;
    }

    public void setCountBook(int countBook) {
        this.countBook = countBook;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storageId=" + storageId +
                ", bookId=" + bookId +
                ", countBook=" + countBook +
                '}';
    }
}
