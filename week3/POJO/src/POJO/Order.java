package POJO;

import java.util.Date;
import java.util.Objects;

public class Order {
    private Long orderId;
    private Customer customer;
    private Cake cake;
    private Coffee coffee;
    private Date orderDate;

    public Order() {}

    public Order(Long orderId, Customer customer, Cake cake, Coffee coffee, Date orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.cake = cake;
        this.coffee = coffee;
        this.orderDate = orderDate;
    }

    public Order(Long orderId, Customer customer, Coffee coffee, Date orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.coffee = coffee;
        this.orderDate = orderDate;
    }

    public Order(Long orderId, Customer customer, Cake cake, Date orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.cake = cake;
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId.equals(order.orderId) && customer.equals(order.customer) && Objects.equals(cake, order.cake) && Objects.equals(coffee, order.coffee) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customer, cake, coffee, orderDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", cake=" + cake +
                ", coffee=" + coffee +
                ", orderDate=" + orderDate +
                '}';
    }
}
