package com.example.books.service;

import com.example.books.entity.Customer;
import com.example.books.excepetion.CustomerException;
import com.example.books.model.CustomerModel;
import com.example.books.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer addCustomer(Customer customer) throws CustomerException {
        if (customerRepo.findCustomerByEmail(customer.getEmail()) != null) {
            throw new CustomerException("Пользователь с таким email уже существует");
        }
        return customerRepo.save(customer);
    }

    public CustomerModel findOneCustomer(Integer id) throws CustomerException {
        Customer customer = customerRepo.findById(id).get();
        if (customer == null) {
            throw new CustomerException("Пользователь не найден");
        }
        return CustomerModel.toModel(customer);
    }

    public int deleteCustomer(Integer id) throws CustomerException {
        if (!customerRepo.existsById(id)) {
            throw new CustomerException("Пользователь не найден");
        }
        customerRepo.deleteById(id);
        return id;
    }

    public Customer updateCustomer(Integer id,CustomerModel model) throws CustomerException {
        if (!customerRepo.existsById(id)) {
            throw new CustomerException("Пользователь не найден");
        }
        Customer customer = customerRepo.findById(id).get();
        customer.setFirstName(model.getFirstName());
        customer.setLastName(model.getLastName());
        customer.setPhoneNumber(model.getPhoneNumber());
        return customerRepo.save(customer);
    }

    public List<CustomerModel> convertCustomerToModel(Iterable<Customer> customers) {
        List<CustomerModel> customerModelList = new ArrayList<>();
        for (Customer customer : customers)
        {
            customerModelList.add(CustomerModel.toModel(customer));
        }
        return customerModelList;
    }

    public List<CustomerModel> getAllCustomers() {
        return convertCustomerToModel(customerRepo.findAll());
    }
}
