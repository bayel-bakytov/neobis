package com.example.books.controller;

import com.example.books.entity.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void addNewCategory() throws Exception {
        Category category = new Category(2,"history","about history");
        String toJson = mapper.writeValueAsString(category);
        mockMvc.perform(post("http://localhost:8081/book/category/add-category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

    @Test
    void getAllCategories() throws Exception{
        mockMvc.perform(get("http://localhost:8081/book/category/all-categories"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findCategory() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/category/find/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void editCategory() throws  Exception{
        Category category = new Category();
        category.setName("programming");
        category.setDescription("about programming");
        String toJson = mapper.writeValueAsString(category);
        mockMvc.perform(MockMvcRequestBuilders.put("http://localhost:8081/book/category/edit/{id}",5)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteCategory() throws Exception {
        mockMvc.perform(delete("http://localhost:8081/book/category/delete/{id}",5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}