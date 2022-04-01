package com.example.books.controller;

import com.example.books.entity.Employee;
import com.example.books.excepetion.NotFoundException;
import com.example.books.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add-employee")
    public ResponseEntity addNewEmployee(@RequestBody Employee employee) {
        try {
            employeeService.add(employee);
            return ResponseEntity.ok("Работник успешно добавлен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all-employee")
    public ResponseEntity getAllCustomerModel() {
        try {
            return ResponseEntity.ok(employeeService.getAll());
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("find/{id}")
    public ResponseEntity findEmployeeById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(employeeService.findById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editEmployee(@PathVariable Integer id,@RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(employeeService.updateEntity(id,employee));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(employeeService.deleteById(id));
        } catch (NotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
