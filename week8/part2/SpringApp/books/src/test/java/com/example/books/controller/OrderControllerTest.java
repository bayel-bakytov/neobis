package com.example.books.controller;

import com.example.books.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void addNewOrder() throws  Exception{
        Order order = new Order();
        order.setOrderId(2);
        Customer customer = new Customer();
        customer.setFirstName("roman");
        customer.setLastName("kononov");
        customer.setEmail("2@gmail.com");
        customer.setAddress("12");
        customer.setCity("karakol");
        customer.setPhoneNumber("3922");
        customer.setId(2);
        order.setCustomerId(customer);
        String toJson = mapper.writeValueAsString(order);
        mockMvc.perform(post("http://localhost:8081/book/orders/add-order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllOrders() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/orders/all-orders"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findOrderById() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/orders/find/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteOrder() throws Exception {
        mockMvc.perform(delete("http://localhost:8081/book/orders/delete/{id}",5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}