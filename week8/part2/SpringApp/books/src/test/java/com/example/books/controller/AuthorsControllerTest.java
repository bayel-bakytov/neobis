package com.example.books.controller;

import com.example.books.entity.Authors;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AuthorsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void addAuthor() throws Exception {
        Authors author = new Authors(1,"Artur","Kovalev");
        String toJson = mapper.writeValueAsString(author);
        mockMvc.perform(post("http://localhost:8081/book/authors/add-author")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllAuthorsModel() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/authors/all-authors"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findAuthor() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/authors/find/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void editAuthor() throws Exception {
        Authors author = new Authors(1,"robert","martin");
        String toJson = mapper.writeValueAsString(author);
        mockMvc.perform(put("http://localhost:8081/book/authors/edit/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteAuthor() throws Exception{
        mockMvc.perform(delete("http://localhost:8081/book/authors/delete/4")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk());
    }
}