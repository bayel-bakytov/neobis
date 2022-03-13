package com.example.books.model;

import com.example.books.entity.Customer;

public class CustomerModel {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public static CustomerModel toModel(Customer customer) {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customer.getId());
        customerModel.setLastName(customer.getLastName());
        customerModel.setFirstName(customer.getFirstName());
        customerModel.setPhoneNumber(customer.getPhoneNumber());
        return customerModel;
    }

    public CustomerModel() {

    }

    public CustomerModel(int id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
