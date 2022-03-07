package com.example.books.service;

import com.example.books.entity.Employee;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.EmployeeModel;
import com.example.books.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<EmployeeModel> convertEmployeeToModel(Iterable<Employee> employees) {
        List<EmployeeModel> employeeModelList = new ArrayList<>();
        for (Employee employee : employees)
        {
            employeeModelList.add(EmployeeModel.toModel(employee));
        }
        return employeeModelList;
    }

    public List<EmployeeModel> getAllEmployees() {
        return convertEmployeeToModel(employeeRepo.findAll());
    }

    public EmployeeModel findOneEmployee(Integer id) throws NotFoundException {
        Employee employee = employeeRepo.findById(id).get();
        if (employee == null) {
            throw new NotFoundException("Работник не найден");
        }
        return EmployeeModel.toModel(employee);
    }

    public int deleteEmployee(Integer id) throws NotFoundException {
        if (!employeeRepo.existsById(id)) {
            throw new NotFoundException("Работник не найден");
        }
        employeeRepo.deleteById(id);
        return id;
    }

    public Employee updateEmployee(Integer id, Employee model) throws NotFoundException {
        if (!employeeRepo.existsById(id)) {
            throw new NotFoundException("Работник не найден");
        }
        Employee employee = employeeRepo.findById(id).get();
        employee.setEmployeeId(model.getEmployeeId());
        employee.setFirstName(model.getFirstName());
        employee.setLastName(model.getLastName());
        employee.setSalary(model.getSalary());
        return employeeRepo.save(employee);
    }

}
