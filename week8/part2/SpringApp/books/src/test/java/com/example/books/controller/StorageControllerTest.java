package com.example.books.controller;

import com.example.books.entity.*;
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
class StorageControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void addNewStorage() throws Exception {
        Storage storage = new Storage();
        storage.setCount(10);
        Book book = new Book();
        book.setBookId(5);
        book.setTitle("about pr");
        book.setAuthorId(new Authors(1,"pol","lop"));
        book.setPriceId(new Price(2,500.0));
        book.setGenreId(new Category(1,"program","pr"));
        book.setPagesCount(80);
        storage.setBookId(book);
        String toJson = mapper.writeValueAsString(storage);
        mockMvc.perform(post("http://localhost:8081/book/storages/add-storage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllStorages() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/storages/all-storages"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findStorageById() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/storages/find/{id}",10))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteStorage() throws Exception {
        mockMvc.perform(delete("http://localhost:8081/book/storages/delete/{id}",10)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}