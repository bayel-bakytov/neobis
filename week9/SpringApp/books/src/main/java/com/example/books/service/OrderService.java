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
public class OrderService implements Crud<Order,OrderModel,Integer>{
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void add(Order order) {
        orderRepo.save(order);
    }

    @Override
    public List<OrderModel> convertToModel(Iterable<Order> orders) {
        List<OrderModel> orderModelList = new ArrayList<>();
        for (Order order : orders)
        {
            orderModelList.add(OrderModel.toModel(order));
        }
        System.out.println(orderModelList);
        return orderModelList;
    }

    @Override
    public List<OrderModel> getAll() throws NotFoundException {
        return convertToModel(orderRepo.findAll());
    }

    @Override
    public OrderModel findById(Integer id) throws NotFoundException {
        Order order = orderRepo.findById(id).get();
        if (order == null) {
            throw new NotFoundException("заказ не найден");
        }
        return OrderModel.toModel(order);
    }

    @Override
    public int deleteById(Integer id) throws NotFoundException {
        if (!orderRepo.existsById(id)) {
            throw new NotFoundException("заказ не найден");
        }
        orderRepo.deleteById(id);
        return id;
    }

    @Override
    public Order updateEntity(Integer id, Order orderChange) throws NotFoundException {
        if (!orderRepo.existsById(id)) {
            throw new NotFoundException("заказ не найден");
        }
        Order order = orderRepo.findById(id).get();
        order.setOrderId(orderChange.getOrderId());
        order.setOrderDate(orderChange.getOrderDate());
        order.setCustomerId(orderChange.getCustomerId());
        order.setBookId(orderChange.getBookId());
        return orderRepo.save(order);
    }
}
