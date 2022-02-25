package com.example.books.service;

import com.example.books.entity.Order;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.OrderModel;
import com.example.books.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    public List<OrderModel> convertOrderToModel(Iterable<Order> orders) {
        List<OrderModel> orderModelList = new ArrayList<>();
        for (Order order : orders)
        {
            orderModelList.add(OrderModel.toModel(order));
        }
        System.out.println(orderModelList);
        return orderModelList;
    }

    public List<OrderModel> getAllOrders() {
        return convertOrderToModel(orderRepo.findAll());
    }

    public OrderModel findOneOrder(Integer id) throws NotFoundException {
        Order order = orderRepo.findById(id).get();
        if (order == null) {
            throw new NotFoundException("заказ не найден");
        }
        return OrderModel.toModel(order);
    }

    public int deleteOrder(Integer id) throws NotFoundException {
        if (!orderRepo.existsById(id)) {
            throw new NotFoundException("заказ не найден");
        }
        orderRepo.deleteById(id);
        return id;
    }

    public Order updateOrder(Integer id, Order model) throws NotFoundException {
        if (!orderRepo.existsById(id)) {
            throw new NotFoundException("заказ не найден");
        }
        Order order = orderRepo.findById(id).get();
        order.setOrderId(model.getOrderId());
        order.setOrderDate(model.getOrderDate());
        order.setCustomerId(model.getCustomerId());
        order.setBookId(model.getBookId());
        return orderRepo.save(order);
    }

}
