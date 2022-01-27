package POJO;

public class Storage {
    private int bookId;
    private int count;

    public Storage() {};

    public Storage(int bookId, int count) {
        this.bookId = bookId;
        this.count = count;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "bookId=" + bookId +
                ", count=" + count +
                '}';
    }
}
