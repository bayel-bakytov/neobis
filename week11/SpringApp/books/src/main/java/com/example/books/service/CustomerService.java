package com.example.books.service;

import com.example.books.entity.Customer;
import com.example.books.excepetion.CustomerException;
import com.example.books.excepetion.NotFoundException;
import com.example.books.model.CustomerModel;
import com.example.books.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements Crud<Customer,CustomerModel,Integer>{
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void add(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public List<CustomerModel> convertToModel(Iterable<Customer> customers) {
        List<CustomerModel> customerModelList = new ArrayList<>();
        for (Customer customer : customers)
        {
            customerModelList.add(CustomerModel.toModel(customer));
        }
        return customerModelList;    }

    @Override
    public List<CustomerModel> getAll() throws NotFoundException {
        return convertToModel(customerRepo.findAll());
    }

    @Override
    public CustomerModel findById(Integer id) throws NotFoundException {
        Customer customer = customerRepo.findById(id).get();
        if (customer == null) {
            throw new NotFoundException("Пользователь не найден");
        }
        return CustomerModel.toModel(customer);
    }

    @Override
    public int deleteById(Integer id) throws NotFoundException {
        if (!customerRepo.existsById(id)) {
            throw new NotFoundException("Пользователь не найден");
        }
        customerRepo.deleteById(id);
        return id;    }

    @Override
    public Customer updateEntity(Integer id, Customer customerChange) throws NotFoundException {
        if (!customerRepo.existsById(id)) {
            throw new NotFoundException("Пользователь не найден");
        }
        Customer customer = customerRepo.findById(id).get();
        customer.setFirstName(customerChange.getFirstName());
        customer.setLastName(customerChange.getLastName());
        customer.setPhoneNumber(customerChange.getPhoneNumber());
        return customerRepo.save(customer);
    }
}
