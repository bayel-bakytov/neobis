package POJO;

import java.util.Date;

public class Order {
    private Long orderId;
    private Customer customerId;
    private Book bookId;
    private Date orderDate;

    public Order (){};

    public Order(Long orderId, Customer customerId, Book bookId, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.bookId = bookId;
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", bookId=" + bookId +
                ", orderDate=" + orderDate +
                '}';
    }
}
