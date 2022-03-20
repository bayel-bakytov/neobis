package com.example.books.model;

import com.example.books.entity.Employee;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeModel {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Double salary;

    public EmployeeModel() {}

    public static EmployeeModel toModel(Employee employee) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setEmployeeId(employee.getEmployeeId());
        employeeModel.setFirstName(employee.getFirstName());
        employeeModel.setLastName(employee.getLastName());
        employeeModel.setSalary(employee.getSalary());
        return employeeModel;
    }

    public EmployeeModel(Integer employeeId, String firstName, String lastName, Double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
}
