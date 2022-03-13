package com.example.books.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
    @OneToOne
    @JoinColumn(name = "book_id",referencedColumnName = "book_id")
    private Book bookId;
    @Column(name = "order_date")
    private Date orderDate;

    public Order(Integer orderId, Customer customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }
}