package com.example.books.model;

import com.example.books.entity.Book;
import com.example.books.entity.Customer;
import com.example.books.entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderModel {
    private Integer orderId;
    private Customer customerId;
    private Book bookId;
    private Date orderDate;

    public OrderModel() {}

    public static OrderModel toModel(Order order) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(order.getOrderId());
        orderModel.setCustomerId(order.getCustomerId());
        orderModel.setBookId(order.getBookId());
        orderModel.setOrderDate(order.getOrderDate());
        return orderModel;
    }

    public OrderModel(Integer orderId, Customer customerId, Book bookId, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.bookId = bookId;
        this.orderDate = orderDate;
    }
}
