package com.example.books.controller;

import com.example.books.entity.Authors;
import com.example.books.entity.Book;
import com.example.books.entity.Category;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void addNewBook() throws Exception{
        Book book = new Book();
        book.setBookId(12);
        book.setTitle("about pr");
        book.setAuthorId(new Authors(1,"pol","lop"));
        book.setPriceId(new Price(2,500.0));
        book.setGenreId(new Category(1,"program","pr"));
        book.setPagesCount(80);
        String toJson = mapper.writeValueAsString(book);
        mockMvc.perform(post("http://localhost:8081/book/add-book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

    @Test
    void getAllBookPrices() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/all-books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findBookById() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/find/{id}",4))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void editBook() throws Exception{
        Book book = new Book();
        book.setBookId(14);
        book.setTitle("history");
        book.setAuthorId(new Authors(1,"pol","lop"));
        book.setPriceId(new Price(2,500.0));
        book.setGenreId(new Category(1,"program","pr"));
        book.setPagesCount(80);
        String toJson = mapper.writeValueAsString(book);
        mockMvc.perform(put("http://localhost:8081/book/edit/14")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteBook() throws Exception {
        mockMvc.perform(delete("http://localhost:8081/book/delete/{id}",15)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}