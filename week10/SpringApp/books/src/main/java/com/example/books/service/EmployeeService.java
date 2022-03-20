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
public class EmployeeService implements Crud<Employee,EmployeeModel,Integer> {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void add(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public List<EmployeeModel> convertToModel(Iterable<Employee> employees) {
        List<EmployeeModel> employeeModelList = new ArrayList<>();
        for (Employee employee : employees)
        {
            employeeModelList.add(EmployeeModel.toModel(employee));
        }
        return employeeModelList;
    }

    @Override
    public List<EmployeeModel> getAll() throws NotFoundException {
        return convertToModel(employeeRepo.findAll());
    }

    @Override
    public EmployeeModel findById(Integer id) throws NotFoundException {
        Employee employee = employeeRepo.findById(id).get();
        if (employee == null) {
            throw new NotFoundException("Работник не найден");
        }
        return EmployeeModel.toModel(employee);
    }

    @Override
    public int deleteById(Integer id) throws NotFoundException {
        if (!employeeRepo.existsById(id)) {
            throw new NotFoundException("Работник не найден");
        }
        employeeRepo.deleteById(id);
        return id;
    }

    @Override
    public Employee updateEntity(Integer id, Employee employeeChange) throws NotFoundException {
        if (!employeeRepo.existsById(id)) {
            throw new NotFoundException("Работник не найден");
        }
        Employee employee = employeeRepo.findById(id).get();
        employee.setEmployeeId(employeeChange.getEmployeeId());
        employee.setFirstName(employeeChange.getFirstName());
        employee.setLastName(employeeChange.getLastName());
        employee.setSalary(employeeChange.getSalary());
        return employeeRepo.save(employee);
    }
}
