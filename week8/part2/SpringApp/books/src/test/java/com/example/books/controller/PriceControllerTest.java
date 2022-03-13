package com.example.books.controller;

import com.example.books.entity.Price;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void addNewPrice() throws Exception{
        Price price = new Price();
        price.setPriceSale(600.0);
        String toJson = mapper.writeValueAsString(price);
        mockMvc.perform(post("http://localhost:8081/book/prices/add-price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllBookPrices() throws Exception{
        mockMvc.perform(get("http://localhost:8081/book/prices/all-prices"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findPriceById() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/prices/find/{id}",2))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void editPrice() throws Exception {
        Price price = new Price();
        price.setPriceId(2);
        price.setPriceSale(600.0);
        String toJson = mapper.writeValueAsString(price);
        mockMvc.perform(put("http://localhost:8081/book/prices/edit/{id}",2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deletePrice() throws Exception {
        mockMvc.perform(delete("http://localhost:8081/book/prices/delete/{id}",6)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}