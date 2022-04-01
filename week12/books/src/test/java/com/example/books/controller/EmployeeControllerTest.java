package com.example.books.controller;

import com.example.books.entity.Employee;
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
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void addNewEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setSalary(2000.0);
        employee.setFirstName("archo");
        employee.setLastName("morris");
        employee.setEmail("1@gmail.com");
        employee.setPhoneNumber("996708554466");
        String toJson = mapper.writeValueAsString(employee);
        mockMvc.perform(post("http://localhost:8081/book/employees/add-employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllCustomerModel() throws  Exception{
        mockMvc.perform(get("http://localhost:8081/book/employees/all-employee"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findEmployeeById() throws Exception {
        mockMvc.perform(get("http://localhost:8081/book/employees/find/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void editEmployee() throws  Exception{
        Employee employee = new Employee();
        employee.setSalary(3000.0);
        employee.setEmployeeId(6);
        employee.setFirstName("archo");
        employee.setLastName("morris");
        employee.setEmail("1@gmail.com");
        employee.setPhoneNumber("996708554466");
        String toJson = mapper.writeValueAsString(employee);
        mockMvc.perform(put("http://localhost:8081/book/employees/edit/{id}",6)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteEmployee() throws Exception{
        mockMvc.perform(delete("http://localhost:8081/book/employees/delete/{id}",6)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}